package br.com.devschool.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária para facilitar a manipulação de textos.
 */
public class StringUtil {

    public static String getStackTrace(Throwable aThrowable) {
        final Writer writer = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(writer);
        aThrowable.printStackTrace(printWriter);

        String stackTrace = writer.toString();

        //Evita IndexOutOfBoundsException 
        if (stackTrace.length() < 20000) {
            return stackTrace;
        } else {
            return writer.toString().substring(0, 20000);
        }
    }
    
    /**
     * Este método recebe uma String e a devolve encriptografada [MD5]
     * 
     * @param String senha
     * @return String
     */
    public static String criptografar(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash;
            hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));
            sen = hash.toString(16);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sen.toUpperCase();
    }
}
