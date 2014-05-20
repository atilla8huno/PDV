package br.com.devschool.forma_pagamento.servico;

import br.com.devschool.entidade.FormaPagamento;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormaPagamentoServico extends Servico<FormaPagamento> {
    
    private Connection conn;
    private FormaPagamentoDAO dao;

    public FormaPagamentoServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new FormaPagamentoDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public FormaPagamentoServico(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
            dao = new FormaPagamentoDAO(this.conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public FormaPagamento salvar(FormaPagamento entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade);
        } else if (entidade.getDescricao() == null || entidade.getDescricao().equals("")) {
            throw new IllegalArgumentException("É necessário preencher os campos obrigatórios!");
        }
        
        try {
            iniciarTransacao();
            entidade = dao.salvar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public FormaPagamento salvar(FormaPagamento entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade, conn);
        } else if (entidade.getDescricao() == null || entidade.getDescricao().equals("")) {
            throw new IllegalArgumentException("É necessário preencher os campos obrigatórios!");
        }
        
        try {
            dao = new FormaPagamentoDAO(conn);
            
            return dao.salvar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public FormaPagamento atualizar(FormaPagamento entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum FormaPagamento foi informado!");
        } else if (entidade.getDescricao() == null || entidade.getDescricao().equals("")) {
            throw new IllegalArgumentException("É necessário preencher os campos obrigatórios!");
        }
        
        try {
            iniciarTransacao();
            entidade = dao.atualizar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public FormaPagamento atualizar(FormaPagamento entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum FormaPagamento foi informado!");
        } else if (entidade.getDescricao() == null || entidade.getDescricao().equals("")) {
            throw new IllegalArgumentException("É necessário preencher os campos obrigatórios!");
        }
        
        try {
            dao = new FormaPagamentoDAO(conn);
            
            return dao.atualizar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public void excluir(FormaPagamento entidade) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum FormaPagamento foi informado!");
        }
        
        excluir(entidade.getId());
    }
    
    @Override
    public void excluir(FormaPagamento entidade, Connection conn) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum FormaPagamento foi informado!");
        }
        
        excluir(entidade.getId(), conn);
    }
    
    @Override
    public void excluir(Integer id) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum FormaPagamento foi informado!");
        }
        
        try {
            iniciarTransacao();
            dao.excluir(id);
            commit();
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public void excluir(Integer id, Connection conn) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum FormaPagamento foi informado!");
        }
        
        try {
            dao = new FormaPagamentoDAO(conn);
            dao.excluir(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public List<FormaPagamento> consultarPor(String descricao) throws PDVException {
        descricao = descricao == null ? "" : descricao;
        
        try {
            dao = new FormaPagamentoDAO(conn);
            return dao.consultarPor(descricao);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<FormaPagamento> consultar() throws PDVException {
        try {
            dao = new FormaPagamentoDAO(conn);
            return dao.consultar();
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<FormaPagamento> consultar(int maxResult) throws PDVException {
        maxResult = maxResult < 1 ? 20 : maxResult > 30 ? 30 : maxResult;
        
        try {
            dao = new FormaPagamentoDAO(conn);
            return dao.consultar(maxResult);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public FormaPagamento consultarPor(int id) throws PDVException {
        try {
            dao = new FormaPagamentoDAO(conn);
            return dao.consultarPor(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    private void iniciarTransacao() throws Exception {
        conn.setAutoCommit(Boolean.FALSE);
    }
    
    private void commit() throws Exception {
        conn.commit();
    }
    
    private void rollback() {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(FormaPagamentoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
