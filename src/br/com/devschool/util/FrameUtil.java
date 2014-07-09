package br.com.devschool.util;

import br.com.devschool.entidade.Funcionario;
import br.com.devschool.entidade.Terminal;
import br.com.devschool.login.visao.LoginFrame;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public abstract class FrameUtil extends JFrame {
    
    public FrameUtil() throws PDVException {
        if (FrameUtil.FUNCIONARIO_LOGADO == null || FrameUtil.FUNCIONARIO_LOGADO.isTransient()) {
            new LoginFrame().setVisible(Boolean.TRUE);
            dispose();
            throw new PDVException("Erro de Login! Nenhum funcionário logado foi localizado.");
        }
    }
    
    public static Funcionario FUNCIONARIO_LOGADO = new Funcionario();
    public static Terminal TERMINAL_LOGADO = new Terminal();
    
    public static Border BORDA_VERMELHA = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51));
    public static Border BORDA_PADRAO   = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175));

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
    public void addMensagem(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }
    
    /**
     * Exibe a mensagem de inclusão com sucesso.
     */
    public void addMensagemSalvoSucesso() {
        addMensagemInfo("Registro salvo com sucesso!");
    }
    
    /**
     * Exibe a mensagem de inclusão com sucesso.
     */
    public void addMensagemExcluidoSucesso() {
        addMensagemInfo("Registro excluído com sucesso!");
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro.
     * 
     * @param msg 
     */
    public void addMensagem(String msg) {
        addMensagemInfo(msg);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Erro
     * 
     * @param msg 
     */
    public void addMensagemErro(String msg) {
        addMensagem(msg, "ERRO", TYPE_ERROR);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Informação
     * 
     * @param msg 
     */
    public void addMensagemInfo(String msg) {
        addMensagem(msg, "INFO", TYPE_INFO);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Aviso
     * 
     * @param msg 
     */
    public void addMensagemAviso(String msg) {
        addMensagem(msg, "AVISO", TYPE_WARN);
    }
    
    /**
     * Exibe a mensagem recebida por parâmetro no formato de Pergunta
     * 
     * @param msg 
     */
    public void addMensagemPergunta(String msg) {
        addMensagem(msg, "DÚVIDA", TYPE_ANSWER);
    }
    
    /**
     * Este método limpa todos os campos do container recebido por argumento.
     */
    public static void limparCamposDoContainer(Container cont){
        for(Component c : cont.getComponents()){
            if(c instanceof JTextField){
                JTextField temp = (JTextField) c;
                temp.setText("");
            } else if (c instanceof JFormattedTextField){
                JFormattedTextField temp = (JFormattedTextField) c;
                temp.setText("");
            } else if (c instanceof JComboBox){
                JComboBox temp = (JComboBox) c;
                temp.setSelectedIndex(0);
            } else if (c instanceof JTextArea){
                JTextArea temp = (JTextArea) c;
                temp.setText("");
            } else if (c instanceof JCheckBox){
                JCheckBox temp = (JCheckBox) c;
                temp.setSelected(Boolean.FALSE);
            } else if (c instanceof Container){
                Container temp = (Container) c;
                limparCamposDoContainer(temp);
            }
        }
    }
}
