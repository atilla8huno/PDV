package br.com.devschool.util;

import javax.swing.JOptionPane;

public class MensagemUtil {

    public static final int TYPE_ERROR  = 0;
    public static final int TYPE_INFO   = 1;
    public static final int TYPE_WARN   = 2;
    public static final int TYPE_ANSWER = 3;
    
    /**
     * Exibe uma mensagem de acordo com parâmetros recebidos.
     * 
     * @param msg
     * @param titulo
     * @param tipo 
     */
    public static void addMensagem(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }
    
    /**
     * Exibe a mensagem de inclusão com sucesso.
     * 
     * @param msg 
     */
    public static void addMensagemSalvoSucesso() {
        addMensagemInfo("Registro salvo com sucesso!");
    }
    
    /**
     * Exibe a mensagem de inclusão com sucesso.
     * 
     * @param msg 
     */
    public static void addMensagemExcluidoSucesso() {
        addMensagemInfo("Registro excluído com sucesso!");
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro.
     * 
     * @param msg 
     */
    public static void addMensagem(String msg) {
        addMensagemInfo(msg);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Erro
     * 
     * @param msg 
     */
    public static void addMensagemErro(String msg) {
        addMensagem(msg, "ERRO", TYPE_ERROR);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Informação
     * 
     * @param msg 
     */
    public static void addMensagemInfo(String msg) {
        addMensagem(msg, "INFO", TYPE_INFO);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Aviso
     * 
     * @param msg 
     */
    public static void addMensagemAviso(String msg) {
        addMensagem(msg, "AVISO", TYPE_WARN);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Pergunta
     * 
     * @param msg 
     */
    public static void addMensagemPergunta(String msg) {
        addMensagem(msg, "DÚVIDA", TYPE_ANSWER);
    }
}
