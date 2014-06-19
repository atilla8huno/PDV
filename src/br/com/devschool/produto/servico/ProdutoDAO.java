package br.com.devschool.produto.servico;

import br.com.devschool.entidade.Produto;
import br.com.devschool.entidade.UnidadeMedida;
import br.com.devschool.unidade_medida.servico.UnidadeMedidaServico;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO<Produto> {

    private Connection conn;
    
    protected ProdutoDAO(Connection conn) throws PDVException {
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
    protected Produto salvar(Produto entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQLNextal = "SELECT NEXTVAL('pdv.produto_id_produto_seq')";
            PreparedStatement ps = conn.prepareStatement(SQLNextal);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }
            
            String SQL = "INSERT INTO pdv.produto(id_produto, nome, codigo, valor, status, id_unidade_medida) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setInt(3, entidade.getCodigo());
            ps.setDouble(4, entidade.getValor());
            ps.setBoolean(5, entidade.isStatus());
            ps.setInt(6, entidade.getUnidadeMedida().getId());
            
            ps.executeUpdate();
            
            LogUtil.logSQL(ps);
            
            return entidade;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }

    @Override
    protected Produto atualizar(Produto entidade) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "UPDATE pdv.produto SET nome=?, codigo=?, valor=?, status=?, id_unidade_medida=? WHERE id_produto=?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setString(1, entidade.getNome());
            ps.setInt(2, entidade.getCodigo());
            ps.setDouble(3, entidade.getValor());
            ps.setBoolean(4, entidade.isStatus());
            ps.setInt(5, entidade.getUnidadeMedida().getId());
            ps.setInt(6, entidade.getId());
            
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
            
            String SQL = "UPDATE pdv.produto SET status = ? WHERE id_produto = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.FALSE);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            LogUtil.logSQL(ps);
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<Produto> consultar() throws PDVException {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_produto, nome, codigo, valor, status, id_unidade_medida FROM pdv.produto WHERE status = ? LIMIT 20";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            
            ResultSet rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                Integer codigo = rs.getInt(3);
                Double valor = rs.getDouble(4);
                boolean status = rs.getBoolean(5);
                UnidadeMedida unidadeMedida = new UnidadeMedidaServico().consultarPor(rs.getInt(6));
                
                produtos.add(new Produto(id, nome, codigo, valor, status, unidadeMedida));
            }
            
            return produtos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    protected List<Produto> consultarPor(String nome, Integer codigo) throws PDVException {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_produto, nome, codigo, valor, status, id_unidade_medida FROM pdv.produto WHERE status = ? AND nome ILIKE ? ";
            if (codigo != null && codigo > 0) {
                SQL += "AND codigo = ? ";
            }
            SQL += "LIMIT 20";
            
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            ps.setString(2, "%"+ nome +"%");
            if (codigo != null && codigo > 0) {
                ps.setInt(3, codigo);
            }
            
            ResultSet rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer _id = rs.getInt(1);
                String _nome = rs.getString(2);
                Integer _codigo = rs.getInt(3);
                Double _valor = rs.getDouble(4);
                boolean _status = rs.getBoolean(5);
                UnidadeMedida _unidadeMedida = new UnidadeMedidaServico().consultarPor(rs.getInt(6));
                
                produtos.add(new Produto(_id, _nome, _codigo, _valor, _status, _unidadeMedida));
            }
            
            return produtos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected List<Produto> consultar(int maxResult) throws PDVException {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT id_produto, nome, codigo, valor, status, id_unidade_medida FROM pdv.produto WHERE status = ? LIMIT ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setBoolean(1, Boolean.TRUE);
            ps.setInt(2, maxResult);
            
            ResultSet rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                Integer codigo = rs.getInt(3);
                Double valor = rs.getDouble(4);
                boolean status = rs.getBoolean(5);
                UnidadeMedida unidadeMedida = new UnidadeMedidaServico().consultarPor(rs.getInt(6));
                
                produtos.add(new Produto(id, nome, codigo, valor, status, unidadeMedida));
            }
            
            return produtos;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
    
    @Override
    protected Produto consultarPor(int id) throws PDVException {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }
            
            String SQL = "SELECT nome, codigo, valor, status, id_unidade_medida FROM pdv.produto WHERE id_produto = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            LogUtil.logSQL(ps);
            
            Produto produto = null;
            if (rs.next()) {
                String nome = rs.getString(1);
                Integer codigo = rs.getInt(2);
                Double valor = rs.getDouble(3);
                boolean status = rs.getBoolean(4);
                UnidadeMedida unidadeMedida = new UnidadeMedidaServico().consultarPor(rs.getInt(5));
                
                produto = new Produto(id, nome, codigo, valor, status, unidadeMedida);
            }
            
            return produto;
        } catch (Exception e){
            throw new PDVException(e);
        }
    }
}
