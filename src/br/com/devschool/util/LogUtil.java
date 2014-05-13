package br.com.devschool.util;

import br.com.devschool.util.template.DAO;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {

    public static void logSQL(String className, PreparedStatement ps) {
        Logger.getLogger(className).log(Level.INFO, ps.toString());
    }
    
    public static void logSQL(PreparedStatement ps) {
        Logger.getLogger(DAO.class.getName()).log(Level.INFO, ps.toString());
    }
    
    public static void logSQL(String sql) {
        Logger.getLogger(DAO.class.getName()).log(Level.INFO, sql);
    }
}
