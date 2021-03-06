package br.com.devschool.funcionario.servico;

import br.com.devschool.cargo.servico.CargoServico;
import br.com.devschool.entidade.Cargo;
import br.com.devschool.entidade.Funcionario;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends DAO<Funcionario> {

    private Connection conn;
    
    protected FuncionarioDAO(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    protected Funcionario salvar(Funcionario entidade) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('pdv.funcionario_id_funcionario_seq')";
            ps = conn.prepareStatement(SQLNextal);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }
            
            String SQL = "INSERT INTO pdv.funcionario(id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setDate(3, new java.sql.Date(entidade.getDataAdmissao().getTime()));
            ps.setBoolean(4, entidade.isStatus());
            ps.setString(5, entidade.getCpf());
            ps.setString(6, entidade.getSenha());
            ps.setInt(7, entidade.getCargo().getId());
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    @Override
    protected Funcionario atualizar(Funcionario entidade) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.funcionario SET nome=?, data_admissao=?, status=?, cpf=?, senha=?, id_cargo=? WHERE id_funcionario=?";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, entidade.getNome());
            ps.setDate(2, new Date(entidade.getDataAdmissao().getTime()));
            ps.setBoolean(3, entidade.isStatus());
            ps.setString(4, entidade.getCpf());
            ps.setString(5, entidade.getSenha());
            ps.setInt(6, entidade.getCargo().getId());
            ps.setInt(7, entidade.getId());
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }

    @Override
    protected void excluir(Integer id) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.funcionario SET status=? WHERE id_funcionario=?";
            ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.FALSE);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }
    
    @Override
    protected List<Funcionario> consultar() throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo FROM pdv.funcionario WHERE status=? LIMIT 20";
            ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                java.util.Date dataAdmissao = rs.getDate(3);
                boolean status = rs.getBoolean(4);
                String cpf = rs.getString(5);
                String senha = rs.getString(6);
                Cargo cargo = new CargoServico().consultarPor(rs.getInt(7));
                
                funcionarios.add(new Funcionario(id, nome, dataAdmissao, status, cpf, senha, cargo));
            }
            
            return funcionarios;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected List<Funcionario> consultarPor(String nome, Cargo cargo) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo "
                    + " FROM pdv.funcionario WHERE status = ? AND nome ILIKE ? ";
            if (cargo != null && !cargo.isTransient()) {
                SQL += "AND id_cargo = ? ";
            }
            SQL += "LIMIT 20";
            
            ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            ps.setString(2, "%"+ nome +"%");
            if (cargo != null && !cargo.isTransient()) {
                ps.setInt(3, cargo.getId());
            }
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String _nome = rs.getString(2);
                java.util.Date dataAdmissao = rs.getDate(3);
                boolean status = rs.getBoolean(4);
                String cpf = rs.getString(5);
                String senha = rs.getString(6);
                Cargo _cargo = new CargoServico().consultarPor(rs.getInt(7));
                
                funcionarios.add(new Funcionario(id, _nome, dataAdmissao, status, cpf, senha, _cargo));
            }
            
            return funcionarios;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    @Override
    protected List<Funcionario> consultar(int maxResult) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo FROM pdv.funcionario WHERE status = ? LIMIT ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            ps.setInt(2, maxResult);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                java.util.Date dataAdmissao = rs.getDate(3);
                boolean status = rs.getBoolean(4);
                String cpf = rs.getString(5);
                String senha = rs.getString(6);
                Cargo cargo = new CargoServico().consultarPor(rs.getInt(7));
                
                funcionarios.add(new Funcionario(id, nome, dataAdmissao, status, cpf, senha, cargo));
            }
            
            return funcionarios;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    @Override
    protected Funcionario consultarPor(int id) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT nome, data_admissao, status, cpf, senha, id_cargo FROM pdv.funcionario WHERE id_funcionario = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            Funcionario funcionario = null;
            if (rs.next()) {
                String nome = rs.getString(1);
                java.util.Date dataAdmissao = rs.getDate(2);
                boolean status = rs.getBoolean(3);
                String cpf = rs.getString(4);
                String senha = rs.getString(5);
                Cargo cargo = new CargoServico().consultarPor(rs.getInt(6));
                
                funcionario = new Funcionario(id, nome, dataAdmissao, status, cpf, senha, cargo);
            }
            
            return funcionario;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected Funcionario consultarPor(String cpf, String senha) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            String SQL = "SELECT id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo "
                    + "FROM pdv.funcionario WHERE cpf = ? AND senha = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, cpf);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            Funcionario funcionario = null;
            if (rs.next()) {
                boolean status = rs.getBoolean(4);
                
                if (!status) {
                    throw new PDVException("Funcionário encontra-se inativo!");
                }
                
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                java.util.Date dataAdmissao = rs.getDate(3);
                String _cpf = rs.getString(5);
                String _senha = rs.getString(6);
                Cargo cargo = new CargoServico().consultarPor(rs.getInt(7));
                
                funcionario = new Funcionario(id, nome, dataAdmissao, status, _cpf, _senha, cargo);
            }
            
            return funcionario;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected Funcionario consultarPor(String cpf) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            String SQL = "SELECT id_funcionario, nome, data_admissao, status, cpf, senha, id_cargo "
                    + "FROM pdv.funcionario WHERE cpf = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, cpf);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            Funcionario funcionario = null;
            if (rs.next()) {
                boolean status = rs.getBoolean(4);
                
                if (!status) {
                    throw new PDVException("Funcionário encontra-se inativo!");
                }
                
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                java.util.Date dataAdmissao = rs.getDate(3);
                String _cpf = rs.getString(5);
                String senha = rs.getString(6);
                Cargo cargo = new CargoServico().consultarPor(rs.getInt(7));
                
                funcionario = new Funcionario(id, nome, dataAdmissao, status, _cpf, senha, cargo);
            }
            
            return funcionario;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
}
