package br.com.devschool.unidade_medida.servico;

import br.com.devschool.entidade.UnidadeMedida;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnidadeMedidaDAO extends DAO<UnidadeMedida> {

    private Connection conn;
    
    protected UnidadeMedidaDAO(Connection conn) throws PDVException {
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
    protected UnidadeMedida salvar(UnidadeMedida entidade) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('pdv.unidade_medida_id_unidade_medida_seq')";
            ps = conn.prepareStatement(SQLNextal);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }
            
            String SQL = "INSERT INTO pdv.unidade_medida(id_unidade_medida, descricao, sigla) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getDescricao());
            ps.setString(3, entidade.getSigla());
            
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
    protected UnidadeMedida atualizar(UnidadeMedida entidade) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.unidade_medida SET descricao = ?, sigla = ? WHERE id_unidade_medida = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, entidade.getDescricao());
            ps.setString(2, entidade.getSigla());
            ps.setInt(3, entidade.getId());
            
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
            
            String SQL = "DELETE FROM pdv.unidade_medida WHERE id_unidade_medida = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }
    
    @Override
    protected List<UnidadeMedida> consultar() throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<UnidadeMedida> unidade_medidas = new ArrayList<UnidadeMedida>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_unidade_medida, descricao, sigla FROM pdv.unidade_medida LIMIT 20";
            ps = conn.prepareStatement(SQL);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String descricao = rs.getString(2);
                String sigla = rs.getString(3);
                
                unidade_medidas.add(new UnidadeMedida(id, descricao, sigla));
            }
            
            return unidade_medidas;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected List<UnidadeMedida> consultarPor(String descricao, String sigla) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<UnidadeMedida> unidade_medidas = new ArrayList<UnidadeMedida>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_unidade_medida, descricao, sigla FROM pdv.unidade_medida WHERE descricao ILIKE ? AND sigla ILIKE ? LIMIT 20";
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, "%"+ descricao +"%");
            ps.setString(2, "%"+ sigla +"%");
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer _id = rs.getInt(1);
                String _descricao = rs.getString(2);
                String _sigla = rs.getString(3);
                
                unidade_medidas.add(new UnidadeMedida(_id, _descricao, _sigla));
            }
            
            return unidade_medidas;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    @Override
    protected List<UnidadeMedida> consultar(int maxResult) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<UnidadeMedida> unidade_medidas = new ArrayList<UnidadeMedida>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_unidade_medida, descricao, sigla FROM pdv.unidade_medida LIMIT ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, maxResult);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String descricao = rs.getString(2);
                String sigla = rs.getString(3);
                
                unidade_medidas.add(new UnidadeMedida(id, descricao, sigla));
            }
            
            return unidade_medidas;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    @Override
    protected UnidadeMedida consultarPor(int id) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_unidade_medida, descricao, sigla FROM pdv.unidade_medida WHERE id_unidade_medida = ?";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            UnidadeMedida unidade_medida = null;
            if (rs.next()) {
                Integer idUnidadeMedida = rs.getInt(1);
                String descricao = rs.getString(2);
                String sigla = rs.getString(3);
                
                unidade_medida = new UnidadeMedida(idUnidadeMedida, descricao, sigla);
            }
            
            return unidade_medida;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
}
