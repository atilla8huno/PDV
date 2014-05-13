package br.com.devschool.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

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
}
