package br.com.devschool.unidade_medida.servico;

import br.com.devschool.entidade.UnidadeMedida;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeMedidaServico extends Servico<UnidadeMedida> {
    
    private Connection conn;
    private UnidadeMedidaDAO dao;

    public UnidadeMedidaServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new UnidadeMedidaDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public UnidadeMedidaServico(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
            dao = new UnidadeMedidaDAO(this.conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public UnidadeMedida salvar(UnidadeMedida entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade);
        }
        
        try {
            iniciarTransacao();
            
            if (entidade.getSigla().length() > 3) {
                entidade.setSigla(entidade.getSigla().substring(0, 3));
            }
            entidade.setSigla(entidade.getSigla().toUpperCase());
            
            entidade = dao.salvar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public UnidadeMedida salvar(UnidadeMedida entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade, conn);
        }
        
        try {
            dao = new UnidadeMedidaDAO(conn);
            
            if (entidade.getSigla().length() > 3) {
                entidade.setSigla(entidade.getSigla().substring(0, 3));
            }
            entidade.setSigla(entidade.getSigla().toUpperCase());
            
            return dao.salvar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public UnidadeMedida atualizar(UnidadeMedida entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum UnidadeMedida foi informado!");
        }
        
        try {
            iniciarTransacao();
            
            if (entidade.getSigla().length() > 3) {
                entidade.setSigla(entidade.getSigla().substring(0, 3));
            }
            entidade.setSigla(entidade.getSigla().toUpperCase());
            
            entidade = dao.atualizar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public UnidadeMedida atualizar(UnidadeMedida entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum UnidadeMedida foi informado!");
        }
        
        try {
            dao = new UnidadeMedidaDAO(conn);
            
            if (entidade.getSigla().length() > 3) {
                entidade.setSigla(entidade.getSigla().substring(0, 3));
            }
            entidade.setSigla(entidade.getSigla().toUpperCase());
            
            return dao.atualizar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public void excluir(UnidadeMedida entidade) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum UnidadeMedida foi informado!");
        }
        
        excluir(entidade.getId());
    }
    
    @Override
    public void excluir(UnidadeMedida entidade, Connection conn) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum UnidadeMedida foi informado!");
        }
        
        excluir(entidade.getId(), conn);
    }
    
    @Override
    public void excluir(Integer id) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum UnidadeMedida foi informado!");
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
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum UnidadeMedida foi informado!");
        }
        
        try {
            dao = new UnidadeMedidaDAO(conn);
            dao.excluir(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public List<UnidadeMedida> consultarPor(String nome, String perfil) throws PDVException {
        nome = nome == null ? "" : nome;
        perfil = perfil == null ? "" : perfil;
        
        try {
            dao = new UnidadeMedidaDAO(conn);
            return dao.consultarPor(nome, perfil);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<UnidadeMedida> consultar() throws PDVException {
        try {
            dao = new UnidadeMedidaDAO(conn);
            return dao.consultar();
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<UnidadeMedida> consultar(int maxResult) throws PDVException {
        maxResult = maxResult < 1 ? 20 : maxResult > 30 ? 30 : maxResult;
        
        try {
            dao = new UnidadeMedidaDAO(conn);
            return dao.consultar(maxResult);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public UnidadeMedida consultarPor(int id) throws PDVException {
        try {
            dao = new UnidadeMedidaDAO(conn);
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
            Logger.getLogger(UnidadeMedidaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
