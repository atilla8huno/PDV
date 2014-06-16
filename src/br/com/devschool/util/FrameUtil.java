package br.com.devschool.util;

import br.com.devschool.entidade.Funcionario;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FrameUtil {
    
    public static Funcionario funcionarioLogado = new Funcionario();
    
    public static Border BORDA_VERMELHA = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51));
    public static Border BORDA_PADRAO   = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175));

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
