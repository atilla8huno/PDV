package br.com.devschool.venda.servico;

import br.com.devschool.entidade.Venda;
import br.com.devschool.entidade.VendaFormaPagamento;
import br.com.devschool.entidade.VendaProduto;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class VendaDAO {

    private Connection conn;
    
    protected VendaDAO(Connection conn) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                this.conn = ConnectionFactory.getConnection();
            }
            this.conn = conn;
        } catch (Exception e) {
            throw new PDVException(e);
        }
    }

    protected Venda salvar(Venda entidade) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "INSERT INTO pdv.venda(id_venda, data_cadastro, entrega_domicilio, "
                    + "nome_cliente, endereco_cliente, contato_cliente, valor_total, valor_pago, "
                    + "valor_troco, id_terminal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setDate(2, new Date(entidade.getDataCadastro().getTime()));
            ps.setBoolean(3, entidade.isEntregaDomicilio());
            ps.setString(4, entidade.getNomeCliente());
            ps.setString(5, entidade.getEnderecoCliente());
            ps.setString(6, entidade.getContatoCliente());
            ps.setDouble(7, entidade.getValorTotal());
            ps.setDouble(8, entidade.getValorPago());
            ps.setDouble(9, entidade.getValorTroco());
            ps.setInt(10, entidade.getTerminal().getId());
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected Integer consultarProximoId() throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('pdv.venda_id_venda_seq')";
            ps = conn.prepareStatement(SQLNextal);
            rs = ps.executeQuery();
            
            Integer proximoId = null;
            if (rs.next()) {
                proximoId = rs.getInt(1);
            }
            
            return proximoId;
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected void salvarPagamentos(List<VendaFormaPagamento> pagamentos, Connection conn) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "INSERT INTO pdv.venda_forma_pagamento(id_forma_pagamento, id_venda, valor) VALUES (?, ?, ?)";
            
            for (VendaFormaPagamento pgto : pagamentos) {
                ps = conn.prepareStatement(SQL);

                ps.setInt(1, pgto.getFormaPagamento().getId());
                ps.setInt(2, pgto.getVenda().getId());
                ps.setDouble(3, pgto.getValor());

                ps.executeUpdate();
                LogUtil.logSQL(ps);
            }
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected void salvarProdutos(List<VendaProduto> produtos, Connection conn) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "INSERT INTO pdv.venda_produto(id_venda, id_produto, quantidade, valor) VALUES (?, ?, ?, ?)";
            
            for (VendaProduto produto : produtos) {
                ps = conn.prepareStatement(SQL);

                ps.setInt(1, produto.getVenda().getId());
                ps.setInt(2, produto.getProduto().getId());
                ps.setDouble(3, produto.getQuantidade());
                ps.setDouble(4, produto.getValor());

                ps.executeUpdate();
                LogUtil.logSQL(ps);
            }
        } catch (Exception e){
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
}
