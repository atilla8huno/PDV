package br.com.devschool.util.infra_estrutura;

import java.sql.Connection;

/**
 * @author ATILLA
 */
public class ConnectionTest {

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        System.out.println(ConnectionFactory.status);
        ConnectionFactory.getCloseConnection(conn);
    }
}
