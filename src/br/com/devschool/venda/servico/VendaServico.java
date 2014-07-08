package br.com.devschool.venda.servico;

import br.com.devschool.entidade.Venda;
import br.com.devschool.entidade.VendaFormaPagamento;
import br.com.devschool.entidade.VendaProduto;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaServico {
    
    private Connection conn;
    private VendaDAO dao;

    public VendaServico() throws PDVException {
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(Boolean.FALSE);
            dao = new VendaDAO(conn);
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }
    
    public void salvar(Venda entidade) throws PDVException {
        if (entidade == null) {
            throw new IllegalArgumentException("Não é possível salvar os registros, pois nenhum dado foi informado!");
        }
        
        try {
            iniciarTransacao();
            
            salvarPagamentos(entidade.getPagamentos(), conn);
            salvarProdutos(entidade.getProdutos(), conn);
            entidade = dao.salvar(entidade);
            
            commit();
        } catch (Exception e) {
            rollback();
            throw new PDVException(e);
        }
    }
    
    public Integer consultarProximoId() throws PDVException {
        try {
            dao = new VendaDAO(conn);
            return dao.consultarProximoId();
        } catch (PDVException e) {
            throw new PDVException(e);
        }
    }
    
    private void salvarPagamentos(List<VendaFormaPagamento> pagamentos, Connection conn) throws PDVException {
        dao.salvarPagamentos(pagamentos, conn);
    }
    
    private void salvarProdutos(List<VendaProduto> produtos, Connection conn) throws PDVException {
        dao.salvarProdutos(produtos, conn);
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
            Logger.getLogger(VendaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
