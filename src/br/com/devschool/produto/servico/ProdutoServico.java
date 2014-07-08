package br.com.devschool.produto.servico;

import br.com.devschool.entidade.Produto;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoServico extends Servico<Produto> {
    
    private Connection conn;
    private ProdutoDAO dao;

    public ProdutoServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new ProdutoDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public ProdutoServico(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
            dao = new ProdutoDAO(this.conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Produto salvar(Produto entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade);
        }
        
        try {
            iniciarTransacao();
            
            if (entidade.getNome().length() > 45) {
                entidade.setNome(entidade.getNome().substring(0, 45));
            }
            entidade.setNome(entidade.getNome().toUpperCase());
            
            entidade = dao.salvar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public Produto salvar(Produto entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade, conn);
        }
        
        try {
            dao = new ProdutoDAO(conn);
            
            if (entidade.getNome().length() > 45) {
                entidade.setNome(entidade.getNome().substring(0, 45));
            }
            entidade.setNome(entidade.getNome().toUpperCase());
            
            return dao.salvar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public Produto atualizar(Produto entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Produto foi informado!");
        }
        
        try {
            iniciarTransacao();
            
            if (entidade.getNome().length() > 45) {
                entidade.setNome(entidade.getNome().substring(0, 45));
            }
            entidade.setNome(entidade.getNome().toUpperCase());
            
            entidade = dao.atualizar(entidade);
            commit();
            
            return entidade;
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    @Override
    public Produto atualizar(Produto entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Produto foi informado!");
        }
        
        try {
            dao = new ProdutoDAO(conn);
            
            if (entidade.getNome().length() > 45) {
                entidade.setNome(entidade.getNome().substring(0, 45));
            }
            entidade.setNome(entidade.getNome().toUpperCase());
            
            return dao.atualizar(entidade);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public void excluir(Produto entidade) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Produto foi informado!");
        }
        
        excluir(entidade.getId());
    }
    
    @Override
    public void excluir(Produto entidade, Connection conn) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Produto foi informado!");
        }
        
        excluir(entidade.getId(), conn);
    }
    
    @Override
    public void excluir(Integer id) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Produto foi informado!");
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
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Produto foi informado!");
        }
        
        try {
            dao = new ProdutoDAO(conn);
            dao.excluir(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public List<Produto> consultarPor(String nome, Integer codigo) throws PDVException {
        nome = nome == null ? "" : nome;
        
        try {
            dao = new ProdutoDAO(conn);
            return dao.consultarPor(nome, codigo);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Produto> consultar() throws PDVException {
        try {
            dao = new ProdutoDAO(conn);
            return dao.consultar();
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Produto> consultar(int maxResult) throws PDVException {
        maxResult = maxResult < 1 ? 20 : maxResult > 30 ? 30 : maxResult;
        
        try {
            dao = new ProdutoDAO(conn);
            return dao.consultar(maxResult);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Produto consultarPor(int id) throws PDVException {
        try {
            dao = new ProdutoDAO(conn);
            return dao.consultarPor(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public Produto consultarPorCodigo(Integer codigo) throws PDVException {
        try {
            dao = new ProdutoDAO(conn);
            return dao.consultarPorCodigo(codigo);
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
            Logger.getLogger(ProdutoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
