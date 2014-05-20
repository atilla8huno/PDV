package br.com.devschool.forma_pagamento.servico;

import br.com.devschool.entidade.FormaPagamento;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FormaPagamentoDAO extends DAO<FormaPagamento> {

    private Connection conn;
    
    protected FormaPagamentoDAO(Connection conn) throws PDVException {
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
    protected FormaPagamento salvar(FormaPagamento entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('pdv.forma_pagamento_id_forma_pagamento_seq')";
            PreparedStatement ps = conn.prepareStatement(SQLNextal);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }
            
            String SQL = "INSERT INTO pdv.forma_pagamento(id_forma_pagamento, descricao) VALUES(?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getDescricao());
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }

    @Override
    protected FormaPagamento atualizar(FormaPagamento entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.forma_pagamento SET descricao = ? WHERE id_forma_pagamento = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, entidade.getDescricao());
            ps.setInt(2, entidade.getId());
            
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
            
            String SQL = "DELETE FROM pdv.forma_pagamento WHERE id_forma_pagamento = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<FormaPagamento> consultar() throws PDVException {
        try {
            List<FormaPagamento> forma_pagamentos = new ArrayList<FormaPagamento>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_forma_pagamento, descricao FROM pdv.forma_pagamento LIMIT 20";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String descricao = rs.getString(2);
                
                
                forma_pagamentos.add(new FormaPagamento(id, descricao));
            }
            
            return forma_pagamentos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    protected List<FormaPagamento> consultarPor(String descricao) throws PDVException {
        try {
            List<FormaPagamento> forma_pagamentos = new ArrayList<FormaPagamento>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_forma_pagamento, descricao FROM pdv.forma_pagamento WHERE descricao ILIKE ? LIMIT 20";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, "%"+ descricao +"%");
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer _id = rs.getInt(1);
                String _descricao = rs.getString(2);
                
                forma_pagamentos.add(new FormaPagamento(_id, _descricao));
            }
            
            return forma_pagamentos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<FormaPagamento> consultar(int maxResult) throws PDVException {
        try {
            List<FormaPagamento> forma_pagamentos = new ArrayList<FormaPagamento>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_forma_pagamento, descricao FROM pdv.forma_pagamento LIMIT ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, maxResult);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String descricao = rs.getString(2);
                
                forma_pagamentos.add(new FormaPagamento(id, descricao));
            }
            
            return forma_pagamentos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected FormaPagamento consultarPor(int id) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_forma_pagamento, descricao FROM pdv.forma_pagamento WHERE id_forma_pagamento = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            LogUtil.logSQL(ps);
            
            FormaPagamento forma_pagamento = null;
            if (rs.next()) {
                Integer idFormaPagamento = rs.getInt(1);
                String descricao = rs.getString(2);
                
                forma_pagamento = new FormaPagamento(idFormaPagamento, descricao);
            }
            
            return forma_pagamento;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
}
