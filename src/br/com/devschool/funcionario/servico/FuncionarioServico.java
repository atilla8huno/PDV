package br.com.devschool.funcionario.servico;

import br.com.devschool.entidade.Cargo;
import br.com.devschool.entidade.Funcionario;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.Servico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioServico extends Servico<Funcionario> {
    
    private Connection conn;
    private FuncionarioDAO dao;

    public FuncionarioServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new FuncionarioDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public FuncionarioServico(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
            dao = new FuncionarioDAO(this.conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Funcionario salvar(Funcionario entidade) throws PDVException {
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
    public Funcionario salvar(Funcionario entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (!entidade.isTransient()) {
            return atualizar(entidade, conn);
        }
        
        try {
            dao = new FuncionarioDAO(conn);
            
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
    public Funcionario atualizar(Funcionario entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Funcionario foi informado!");
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
    public Funcionario atualizar(Funcionario entidade, Connection conn) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        } else if (entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível atualizar os registros, pois nenhum Funcionario foi informado!");
        }
        
        try {
            dao = new FuncionarioDAO(conn);
            
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
    public void excluir(Funcionario entidade) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Funcionario foi informado!");
        }
        
        excluir(entidade.getId());
    }
    
    @Override
    public void excluir(Funcionario entidade, Connection conn) throws PDVException {
        if (entidade == null || entidade.isTransient()) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Funcionario foi informado!");
        }
        
        excluir(entidade.getId(), conn);
    }
    
    @Override
    public void excluir(Integer id) throws PDVException {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Funcionario foi informado!");
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
            throw new IllegalArgumentException("Não é possível efetivar a exclusão, pois nenhum Funcionario foi informado!");
        }
        
        try {
            dao = new FuncionarioDAO(conn);
            dao.excluir(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public List<Funcionario> consultarPor(String nome, Cargo cargo) throws PDVException {
        nome = nome == null ? "" : nome;
        
        try {
            dao = new FuncionarioDAO(conn);
            return dao.consultarPor(nome, cargo);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Funcionario> consultar() throws PDVException {
        try {
            dao = new FuncionarioDAO(conn);
            return dao.consultar();
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    @Override
    public List<Funcionario> consultar(int maxResult) throws PDVException {
        maxResult = maxResult < 1 ? 20 : maxResult > 30 ? 30 : maxResult;
        
        try {
            dao = new FuncionarioDAO(conn);
            return dao.consultar(maxResult);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    @Override
    public Funcionario consultarPor(int id) throws PDVException {
        try {
            dao = new FuncionarioDAO(conn);
            return dao.consultarPor(id);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public Funcionario consultarPor(String cpf, String senha) throws PDVException {
        if (cpf == null || cpf.equals("") || cpf.equals("   .   .   -  ")
                || senha == null || senha.equals("")) {
            throw new PDVException("Login/Senha devem ser preenchidos corretamente.");
        }
        
        try {
            dao = new FuncionarioDAO(conn);
            return dao.consultarPor(cpf, senha);
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
            Logger.getLogger(FuncionarioServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
