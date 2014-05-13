package br.com.devschool.util.infra_estrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ATILLA
 */
public class ConnectionFactory {

    private static final String url = "jdbc:postgresql://localhost:5432/desenvolvimento";
    private static final String driver = "org.postgresql.Driver";
    private static final String usuario = "postgres";
    private static final String senha = "123456";
    public static String status = "Conexão vazia";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
            status = "Conectado!";
        } catch (ClassNotFoundException e) {
            status = e.getMessage();
        } catch (SQLException e) {
            status = e.getMessage();
        } catch (Exception e) {
            status = e.getMessage();
        }
        return conn;
    }

    public static PreparedStatement getPreparedStatement(String sql){
        PreparedStatement ps = null;
        try{
            ps = getConnection().prepareStatement(sql);
            status = "SQL Preparado!";
        } catch (SQLException e) {
            status = e.getMessage();
        } catch (Exception e) {
            status = e.getMessage();
        }
        return ps;
    }
    
    public static void getCloseConnection(Connection conn,
            Statement stmt, ResultSet rs) throws Exception {
        getClose(conn, stmt, rs);
    }

    public static void getCloseConnection(Connection conn, Statement stmt)
            throws Exception {
        getClose(conn, stmt, null);
    }

    public static void getCloseConnection(Connection conn)
            throws Exception {
        getClose(conn, null, null);
    }

    private static void getClose(Connection conn,
            Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}