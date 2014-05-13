package br.com.devschool.cargo.servico;

import br.com.devschool.entidade.Cargo;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO extends DAO<Cargo> {

    private Connection conn;
    
    protected CargoDAO(Connection conn) throws PDVException {
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
    protected Cargo salvar(Cargo entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('cargo_id_cargo_seq')";
            PreparedStatement ps = conn.prepareStatement(SQLNextal);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }
            
            String SQL = "INSERT INTO pdv.cargo(id_cargo, nome, perfil) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getPerfil());
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }

    @Override
    protected Cargo atualizar(Cargo entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.cargo SET nome = ?, perfil = ? WHERE id_cargo = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getPerfil());
            ps.setInt(3, entidade.getId());
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }

    @Override
    protected void excluir(Integer id) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "DELETE FROM pdv.cargo WHERE id_cargo = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<Cargo> consultar() throws PDVException {
        try {
            List<Cargo> cargos = new ArrayList<Cargo>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_cargo, nome, perfil FROM pdv.cargo LIMIT 20";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String perfil = rs.getString(3);
                
                cargos.add(new Cargo(id, nome, perfil));
            }
            
            return cargos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    protected List<Cargo> consultarPorNomePerfil(String nomeFiltro, String perfilFiltro) throws PDVException {
        try {
            List<Cargo> cargos = new ArrayList<Cargo>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_cargo, nome, perfil FROM pdv.cargo WHERE nome ILIKE ? AND perfil ILIKE ? LIMIT 20";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, "%"+ nomeFiltro +"%");
            ps.setString(2, "%"+ perfilFiltro +"%");
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String perfil = rs.getString(3);
                
                cargos.add(new Cargo(id, nome, perfil));
            }
            
            return cargos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<Cargo> consultar(int maxResult) throws PDVException {
        try {
            List<Cargo> cargos = new ArrayList<Cargo>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_cargo, nome, perfil FROM pdv.cargo LIMIT ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, maxResult);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String perfil = rs.getString(3);
                
                cargos.add(new Cargo(id, nome, perfil));
            }
            
            return cargos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected Cargo consultarPorId(int id) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_cargo, nome, perfil FROM pdv.cargo WHERE id_cargo = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            Cargo cargo = null;
            if (rs.next()) {
                Integer idCargo = rs.getInt(1);
                String nome = rs.getString(2);
                String perfil = rs.getString(3);
                
                cargo = new Cargo(idCargo, nome, perfil);
            }
            
            return cargo;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
}
