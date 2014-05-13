package br.com.devschool.util;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDVException extends Exception {

    private String message;

    public PDVException(Throwable t) {
        if (t instanceof PDVException) {
            setMessage(t.getMessage());
        } else {
            String codigo = String.valueOf(new Date().getTime());
            setMessage("Ocorreu um erro interno! Informe o código " + codigo + " ao suporte do sistema.");
            Logger.getLogger(PDVException.class.getName()).log(Level.SEVERE, getMessage(), t);
        }
    }

    public PDVException(String msg) {
        setMessage(msg);
        writeLog(msg);
    }

    private void writeLog(String msg) {
        Logger.getLogger(PDVException.class.getName()).log(Level.WARNING, msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mensagem) {
        this.message = mensagem;
    }
}
