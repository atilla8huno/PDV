package br.com.devschool.terminal.servico;

import br.com.devschool.entidade.Terminal;
import br.com.devschool.util.LogUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.infra_estrutura.ConnectionFactory;
import br.com.devschool.util.template.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TerminalDAO extends DAO<Terminal> {

    private Connection conn;

    protected TerminalDAO(Connection conn) throws PDVException {
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
    protected Terminal salvar(Terminal entidade) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQLNextal = "SELECT NEXTVAL('pdv.terminal_id_terminal_seq')";
            ps = conn.prepareStatement(SQLNextal);
            rs = ps.executeQuery();

            if (rs.next()) {
                entidade.setId(rs.getInt(1));
            }

            String SQL = "INSERT INTO pdv.terminal(id_terminal, numero, status) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, entidade.getId());
            ps.setInt(2, entidade.getNumero());
            ps.setBoolean(3, entidade.isStatus());

            ps.executeUpdate();
            LogUtil.logSQL(ps);

            return entidade;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    @Override
    protected Terminal atualizar(Terminal entidade) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "UPDATE pdv.terminal SET numero = ?, status = ? WHERE id_terminal = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, entidade.getNumero());
            ps.setBoolean(2, entidade.isStatus());
            ps.setInt(3, entidade.getId());

            ps.executeUpdate();
            LogUtil.logSQL(ps);

            return entidade;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }

    /**
     * Exclusão lógica.
     */
    @Override
    protected void excluir(Integer id) throws PDVException {
        PreparedStatement ps = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "UPDATE pdv.terminal SET status = ? WHERE id_terminal = ?";
            ps = conn.prepareStatement(SQL);

            ps.setBoolean(1, Boolean.FALSE);
            ps.setInt(2, id);

            ps.executeUpdate();
            LogUtil.logSQL(ps);
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps);
        }
    }

    @Override
    protected List<Terminal> consultar() throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Terminal> terminals = new ArrayList<Terminal>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "SELECT id_terminal, numero, status FROM pdv.terminal WHERE status = ? LIMIT 20";
            ps = conn.prepareStatement(SQL);

            ps.setBoolean(1, Boolean.TRUE);

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer numero = rs.getInt(2);
                Boolean status = rs.getBoolean(3);

                terminals.add(new Terminal(id, numero, status));
            }

            return terminals;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    protected List<Terminal> consultarPor(Integer numero, Boolean status) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Terminal> terminals = new ArrayList<Terminal>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "SELECT id_terminal, numero, status FROM pdv.terminal WHERE status = ? ";
            if (numero > 0) {
                SQL = SQL + "AND numero = ? ";
            }
            SQL = SQL + "LIMIT 20";

            ps = conn.prepareStatement(SQL);

            ps.setBoolean(1, status);
            if (numero > 0) {
                ps.setInt(2, numero);
            }

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            while (rs.next()) {
                Integer _id = rs.getInt(1);
                Integer _numero = rs.getInt(2);
                Boolean _status = rs.getBoolean(3);

                terminals.add(new Terminal(_id, _numero, _status));
            }

            return terminals;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    @Override
    protected List<Terminal> consultar(int maxResult) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Terminal> terminals = new ArrayList<Terminal>();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "SELECT id_terminal, numero, status FROM pdv.terminal WHERE status = ? LIMIT ?";
            ps = conn.prepareStatement(SQL);

            ps.setBoolean(1, Boolean.TRUE);
            ps.setInt(2, maxResult);

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer numero = rs.getInt(2);
                Boolean status = rs.getBoolean(3);

                terminals.add(new Terminal(id, numero, status));
            }

            return terminals;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }

    protected List<Terminal> consultarDisponiveis() throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Terminal> terminals = new ArrayList();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL =  "   SELECT DISTINCT t.* "
                        + "     FROM pdv.terminal t "
                        + "LEFT JOIN pdv.movimento_caixa mc "
                        + "       ON (mc.id_terminal = t.id_terminal) "
                        + "    WHERE t.id_terminal  "
                        + "   NOT IN ( "
                        + "		SELECT m.id_terminal  "
                        + "		  FROM pdv.movimento_caixa m  "
                        + "		 WHERE m.data_hora_fechamento IS NULL "
                        + "          ) "
                        + "      AND t.status = TRUE ";
            ps = conn.prepareStatement(SQL);

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer numero = rs.getInt(2);
                Boolean status = rs.getBoolean(3);

                terminals.add(new Terminal(id, numero, status));
            }

            return terminals;
        } catch (SQLException e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    protected List<Terminal> consultarDisponiveisPor(String cpf) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Terminal> terminals = new ArrayList();
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL ="   SELECT DISTINCT t.* " +
                        "     FROM pdv.terminal t  " +
                        "LEFT JOIN pdv.movimento_caixa mc  " +
                        "       ON (mc.id_terminal = t.id_terminal)  " +
                        "    WHERE t.id_terminal   " +
                        "       IN (  " +
                        "	SELECT m.id_terminal   " +
                        "	  FROM pdv.movimento_caixa m " +
                        "    INNER JOIN pdv.funcionario f " +
                        "	    ON f.id_funcionario = m.id_funcionario " +
                        "	 WHERE m.data_hora_fechamento IS NULL " +
                        "	   AND f.cpf = ? " +
                        "	  )  " +
                        "      AND t.status = TRUE ; ";
            ps = conn.prepareStatement(SQL);

            ps.setString(1, cpf);
            
            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer numero = rs.getInt(2);
                Boolean status = rs.getBoolean(3);

                terminals.add(new Terminal(id, numero, status));
            }

            return terminals;
        } catch (SQLException e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
    
    @Override
    protected Terminal consultarPor(int id) throws PDVException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConnectionFactory.getConnection();
            }

            String SQL = "SELECT id_terminal, numero, status FROM pdv.terminal WHERE id_terminal = ?";
            ps = conn.prepareStatement(SQL);

            ps.setInt(1, id);

            rs = ps.executeQuery();
            LogUtil.logSQL(ps);

            Terminal terminal = null;
            if (rs.next()) {
                Integer idTerminal = rs.getInt(1);
                Integer numero = rs.getInt(2);
                Boolean status = rs.getBoolean(3);

                terminal = new Terminal(idTerminal, numero, status);
            }

            return terminal;
        } catch (Exception e) {
            throw new PDVException(e);
        } finally {
            ConnectionFactory.getCloseConnection(ps, rs);
        }
    }
}
