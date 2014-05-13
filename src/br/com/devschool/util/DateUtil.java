package br.com.devschool.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe utilitária para facilitar a manipulação de datas e horas.
 */
public class DateUtil {
    
    private static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Este método recebe uma Data como parâmentro e retorna no formato texto dd/MM/yyyy
     * 
     * @param   data
     * @return  String
     */
    public static String date2String(Date data){
        return formatador.format(data);
    }
    
    /**
     * Este método recebe uma Data em String como parâmentro e retorna em Date dd/MM/yyyy
     * 
     * @param   data
     * @return  Date
     */
    public static Date string2Date(String data) {
        try {
            return formatador.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
