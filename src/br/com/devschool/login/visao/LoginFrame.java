/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devschool.login.visao;

import br.com.devschool.entidade.Funcionario;
import br.com.devschool.entidade.MovimentoCaixa;
import br.com.devschool.entidade.Terminal;
import br.com.devschool.funcionario.servico.FuncionarioServico;
import br.com.devschool.movimento_caixa.servico.MovimentoCaixaServico;
import br.com.devschool.principal.visao.PrincipalFrame;
import br.com.devschool.terminal.servico.TerminalServico;
import br.com.devschool.util.FrameUtil;
import br.com.devschool.util.MensagemUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.StringUtil;
import br.com.devschool.util.enumerador.PerfilEnum;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Lab 19 M 01
 */
public class LoginFrame extends javax.swing.JFrame {

    private FuncionarioServico servico;
    private Funcionario funcionario = null;
    private List<Terminal> terminais = new ArrayList();
    
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        try {
            servico = new FuncionarioServico();
        } catch (PDVException ex) {
            MensagemUtil.addMensagemErro(ex.getMessage());
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data= new
            javax.swing.text.MaskFormatter("###.###.###-##");
            jFormattedTextFieldCpf = new 
            javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonLogar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanelTerminal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTerminal = new javax.swing.JComboBox();
        jButtonLoginEmergencial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DevSchool PDV - Login");
        setResizable(false);

        jPanelPrincipal.setLayout(null);

        jLabel1.setText("CPF:");
        jPanelPrincipal.add(jLabel1);
        jLabel1.setBounds(350, 170, 110, 20);

        jFormattedTextFieldCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldCpfFocusLost(evt);
            }
        });
        jPanelPrincipal.add(jFormattedTextFieldCpf);
        jFormattedTextFieldCpf.setBounds(350, 190, 110, 20);

        jLabel2.setText("Senha:");
        jPanelPrincipal.add(jLabel2);
        jLabel2.setBounds(350, 230, 80, 20);
        jPanelPrincipal.add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(350, 250, 110, 20);

        jButtonLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        jButtonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogarActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonLogar);
        jButtonLogar.setBounds(350, 340, 50, 40);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonSair);
        jButtonSair.setBounds(410, 340, 50, 40);

        jPanelTerminal.setLayout(null);

        jLabel3.setText("Terminal:");
        jPanelTerminal.add(jLabel3);
        jLabel3.setBounds(20, 20, 110, 20);

        jPanelTerminal.add(jComboBoxTerminal);
        jComboBoxTerminal.setBounds(20, 40, 110, 20);

        jPanelPrincipal.add(jPanelTerminal);
        jPanelTerminal.setBounds(330, 270, 150, 70);

        jButtonLoginEmergencial.setText("Emergencial");
        jButtonLoginEmergencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginEmergencialActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButtonLoginEmergencial);
        jButtonLoginEmergencial.setBounds(350, 390, 110, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogarActionPerformed

        logar();
    }//GEN-LAST:event_jButtonLogarActionPerformed

    private void jFormattedTextFieldCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCpfFocusLost

        consultarCPF();
    }//GEN-LAST:event_jFormattedTextFieldCpfFocusLost

    private void jButtonLoginEmergencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginEmergencialActionPerformed

        new LoginEmergencialFrame().setVisible(Boolean.TRUE);
        dispose();
    }//GEN-LAST:event_jButtonLoginEmergencialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogar;
    private javax.swing.JButton jButtonLoginEmergencial;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxTerminal;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelTerminal;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método consulta o acesso do funcionário na base de dados.
     */
    private void logar() {
        try {
            validarCamposObrigatorios();
            String senha = StringUtil.criptografar(new String(jPasswordFieldSenha.getPassword()));
                        
            if (!senha.equals(funcionario.getSenha())) {
                throw new PDVException("Senha inválida!");
            } else {
                if (funcionario.getCargo().getPerfil().equals(PerfilEnum.ATENDENTE.getNome()) ||
                        funcionario.getCargo().getPerfil().equals(PerfilEnum.SUPERVISOR.getNome())) {
                    abrirCaixa();
                }
                FrameUtil.FUNCIONARIO_LOGADO = funcionario;
                new PrincipalFrame().setVisible(Boolean.TRUE);
                dispose();
            }
        } catch (PDVException e) {
            MensagemUtil.addMensagemErro(e.getMessage());
        }
    }
    
    /**
     * Este método valida os campos obrigatórios.
     */
    private void validarCamposObrigatorios() throws PDVException {
        String cpf = jFormattedTextFieldCpf.getText();
            
        if (cpf == null || cpf.equals("") || cpf.equals("   .   .   -  ")
                || jPasswordFieldSenha.getPassword().length == 0) {
            jFormattedTextFieldCpf.setBorder(FrameUtil.BORDA_VERMELHA);
            jPasswordFieldSenha.setBorder(FrameUtil.BORDA_VERMELHA);
            
            throw new PDVException("Os campos CPF e Senha devem ser preenchidos!");
        }
        
        if ((funcionario.getCargo().getPerfil().equals(PerfilEnum.ATENDENTE.getNome()) ||
                funcionario.getCargo().getPerfil().equals(PerfilEnum.SUPERVISOR.getNome())) &&
                jComboBoxTerminal.getSelectedIndex() == 0) {
            jComboBoxTerminal.setBorder(FrameUtil.BORDA_VERMELHA);
            
            throw new PDVException("O campo Terminal deve ser selecionado!");
        }
    }

    /**
     * Este método consulta o funcionário pelo CPF informado.
     */
    private void consultarCPF() {
        try {
            String cpf = jFormattedTextFieldCpf.getText();
            funcionario = servico.consultarPor(cpf);
            
            if (funcionario == null || funcionario.isTransient()) {
                throw new PDVException("CPF inválido.");
            } else {
                if (!funcionario.getCargo().getPerfil().equals(PerfilEnum.ATENDENTE.getNome()) &&
                        !funcionario.getCargo().getPerfil().equals(PerfilEnum.SUPERVISOR.getNome())) {
                    jPanelTerminal.setVisible(Boolean.FALSE);
                } else {
                    preencherComboBoxTerminal();
                    jPanelTerminal.setVisible(Boolean.TRUE);
                }
            }
        } catch (PDVException e) {
            MensagemUtil.addMensagemErro(e.getMessage());
            jFormattedTextFieldCpf.requestFocus();
        }
    }

    /**
     * Este método faz a abertura do caixa caso o funcionário tenha o perfil adequado.
     */
    private void abrirCaixa() throws PDVException {
        MovimentoCaixa movimento = new MovimentoCaixa();
        movimento.setDataHoraAbertura(Calendar.getInstance().getTime());
        movimento.setFuncionario(funcionario);
        
        for (Terminal t : terminais) {
            if (t.getNumero().equals(Integer.parseInt(jComboBoxTerminal.getSelectedItem().toString()))) {
                movimento.setTerminal(t);
                break;
            }
        }
        
        new MovimentoCaixaServico().salvar(movimento);
        
        MensagemUtil.addMensagemInfo("Caixa aberto. Bem-vindo(a), " + funcionario.getNome() + "!");
    }
    
    /**
     * Este método percore os valores do banco de dados de cargos e popula a combobox.
     */
    private void preencherComboBoxTerminal() {
        jComboBoxTerminal.removeAllItems();
        jComboBoxTerminal.addItem(".:: SELECIONE ::.");
        
        try {
            terminais = new TerminalServico().consultarDisponiveis();
            for (Terminal t : terminais) {
                jComboBoxTerminal.addItem(t.getNumero().toString());
            }
        } catch (PDVException ex) {
            MensagemUtil.addMensagemErro(ex.getMessage());
        }
    }
}
