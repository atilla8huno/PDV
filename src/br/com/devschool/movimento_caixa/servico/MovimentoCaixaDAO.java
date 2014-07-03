package br.com.devschool.movimento_caixa.servico;

import br.com.devschool.entidade.Funcionario;
import br.com.devschool.entidade.MovimentoCaixa;
import br.com.devschool.entidade.Terminal;
import br.com.devschool.funcionario.servico.FuncionarioServico;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class MovimentoCaixaDAO extends DAO<MovimentoCaixa> {

    private Connection conn;

    protected MovimentoCaixaDAO(Connection conn) throws PDVException {
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
    protected MovimentoCaixa salvar(MovimentoCaixa entidade) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQLNextal = "SELECT NEXTVAL('pdv.movimento_caixa_id_movimento_caixa_seq')";
            ps = conn.prepareStatement(SQLNextal);
            rs = ps.executeQuery();

            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }

            String SQL = "INSERT INTO pdv.movimento_caixa(id_movimento_caixa, id_terminal, id_funcionario, data_hora_abertura, data_hora_fechamento, fundo_abertura, fundo_fechamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, entidade.getId());
            ps.setInt(2, entidade.getTerminal().getId());
            ps.setInt(3, entidade.getFuncionario().getId());
            ps.setTimestamp(4, entidade.getDataHoraAbertura() == null
                    ? null : new Timestamp(entidade.getDataHoraAbertura().getTime()));
            ps.setTimestamp(5, entidade.getDataHoraFechamento() == null
                    ? null : new Timestamp(entidade.getDataHoraFechamento().getTime()));
            ps.setDouble(6, entidade.getFundoAbertura() == null
                    ? 100.00 : entidade.getFundoAbertura());
            ps.setDouble(7, entidade.getFundoFechamento() == null
                    ? 0.0 : entidade.getFundoFechamento());

            ps.executeUpdate();
            LogUtil.logSQL(ps);

            return entidade;
        } catch (SQLException e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    @Override
    protected MovimentoCaixa atualizar(MovimentoCaixa entidade) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "UPDATE pdv.movimento_caixa SET id_terminal=?, id_funcionario=?, data_hora_abertura=?, data_hora_fechamento=?, fundo_abertura=?, fundo_fechamento=? WHERE id_movimento_caixa = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, entidade.getTerminal().getId());
            ps.setInt(2, entidade.getFuncionario().getId());
            ps.setDate(3, new Date(entidade.getDataHoraAbertura().getTime()));
            ps.setDate(4, new Date(entidade.getDataHoraFechamento().getTime()));
            ps.setDouble(5, entidade.getFundoAbertura());
            ps.setDouble(6, entidade.getFundoFechamento());
            ps.setInt(7, entidade.getId());

            ps.executeUpdate();
            LogUtil.logSQL(ps);

            return entidade;
        } catch (SQLException e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }

    protected MovimentoCaixa consultarEmAbertoPor(Terminal terminal) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "SELECT DISTINCT id_movimento_caixa, id_funcionario, "
                    + " data_hora_abertura, data_hora_fechamento, fundo_abertura, fundo_fechamento "
                    + " FROM pdv.movimento_caixa "
                    + " WHERE data_hora_fechamento IS NULL AND id_terminal = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, terminal.getId());

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            MovimentoCaixa caixa = null;
            if (rs.next()) {
                Integer id = rs.getInt(1);
                Funcionario funcionario = new FuncionarioServico().consultarPor(rs.getInt(2));
                Date dataHoraAbertura = rs.getDate(3);
                Date dataHoraFechamento = rs.getDate(4);
                Double fundoAbertura = rs.getDouble(5);
                Double fundoFechamento = rs.getDouble(6);

                caixa = new MovimentoCaixa(id, dataHoraAbertura, dataHoraFechamento, fundoAbertura, fundoFechamento, terminal, funcionario);
            }

            return caixa;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    @Override
    protected List<MovimentoCaixa> consultar() throws PDVException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<MovimentoCaixa> consultar(int maxResult) throws PDVException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected MovimentoCaixa consultarPor(int id) throws PDVException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void excluir(Integer id) throws PDVException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
