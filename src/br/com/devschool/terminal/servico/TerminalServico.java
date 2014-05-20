package br.com.devschool.terminal.servico;

import br.com.devschool.entidade.Terminal;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TerminalServico extends Servico<Terminal> {
    
    private Connection conn;
    private TerminalDAO dao;

    public TerminalServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new TerminalDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public TerminalServico(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
            dao = new TerminalDAO(this.conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Terminal salvar(Terminal entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade);
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
    public Terminal salvar(Terminal entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade, conn);
        }
        
        try {
            dao = new TerminalDAO(conn);
            return dao.salvar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public Terminal atualizar(Terminal entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Terminal foi informado!");
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
    public Terminal atualizar(Terminal entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Terminal foi informado!");
        }
        
        try {
            dao = new TerminalDAO(conn);
            return dao.atualizar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public void excluir(Terminal entidade) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Terminal foi informado!");
        }
        
        excluir(entidade.getId());
    }
    
    @Override
    public void excluir(Terminal entidade, Connection conn) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Terminal foi informado!");
        }
        
        excluir(entidade.getId(), conn);
    }
    
    @Override
    public void excluir(Integer id) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Terminal foi informado!");
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
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Terminal foi informado!");
        }
        
        try {
            dao = new TerminalDAO(conn);
            dao.excluir(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public List<Terminal> consultarPor(Integer numero, Boolean status) throws PDVException {
        numero = numero == null ? 0 : numero;
        status = status == null ? Boolean.TRUE : status;
        
        try {
            dao = new TerminalDAO(conn);
            return dao.consultarPor(numero, status);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Terminal> consultar() throws PDVException {
        try {
            dao = new TerminalDAO(conn);
            return dao.consultar();
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Terminal> consultar(int maxResult) throws PDVException {
        maxResult = maxResult < 1 ? 20 : maxResult > 30 ? 30 : maxResult;
        
        try {
            dao = new TerminalDAO(conn);
            return dao.consultar(maxResult);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Terminal consultarPor(int id) throws PDVException {
        try {
            dao = new TerminalDAO(conn);
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
            Logger.getLogger(TerminalServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
