package br.com.devschool.funcionario.visao;

import br.com.devschool.entidade.Funcionario;
import br.com.devschool.entidade.Cargo;
import br.com.devschool.funcionario.servico.FuncionarioServico;
import br.com.devschool.cargo.servico.CargoServico;
import br.com.devschool.util.DateUtil;
import br.com.devschool.util.FrameUtil;
import br.com.devschool.util.MensagemUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.StringUtil;
import br.com.devschool.util.template.IFrame;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author @atilla8huno
 */
public class FuncionarioFrame extends FrameUtil implements IFrame<Funcionario> {

    private Funcionario entidade;
    private FuncionarioServico servico;
    private FuncionarioTableModel modeloTabela;
    private List<Funcionario> funcionarios;
    private List<Cargo> cargos;
    
    /** Atributos de filtros */
    private String nome;
    private Cargo cargo;
    
    /**
     * Método construtor
     */
    public FuncionarioFrame() throws PDVException {
        initComponents();
        
        funcionarios = new ArrayList();
        cargos = new ArrayList();
        modeloTabela = new FuncionarioTableModel(funcionarios);
        jTableFuncionarios.setModel(modeloTabela);
        
        try {
            servico = new FuncionarioServico();
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
        
        preencherComboBoxCargo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jTabbedPaneAbas = new javax.swing.JTabbedPane();
        jPanelFormulario = new javax.swing.JPanel();
        jPanelAcaoFormulario = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanelCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCargo = new javax.swing.JComboBox();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data= new
            javax.swing.text.MaskFormatter("###.###.###-##");
            jFormattedTextFieldCpf = new 
            javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jFormattedTextFieldDataAdmissao = new javax.swing.JFormattedTextField();
        try{
            javax.swing.text.MaskFormatter data= new
            javax.swing.text.MaskFormatter("##/##/####");
            jFormattedTextFieldDataAdmissao = new 
            javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jPanelConsulta = new javax.swing.JPanel();
        jPanelAcaoConsulta = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonLimparConsulta = new javax.swing.JButton();
        jPanelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeFuncionarioFiltro = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxCargoFiltro = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caso de Uso: Funcionário");
        setResizable(false);

        jPanelPrincipal.setLayout(null);

        jPanelFormulario.setLayout(null);

        jPanelAcaoFormulario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcaoFormulario.setLayout(null);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/disk.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanelAcaoFormulario.add(jButtonSalvar);
        jButtonSalvar.setBounds(30, 30, 120, 50);

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clean.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });
        jPanelAcaoFormulario.add(jButtonLimpar);
        jButtonLimpar.setBounds(180, 30, 120, 50);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        jPanelAcaoFormulario.add(jButtonFechar);
        jButtonFechar.setBounds(640, 30, 120, 50);

        jPanelFormulario.add(jPanelAcaoFormulario);
        jPanelAcaoFormulario.setBounds(10, 460, 790, 110);

        jPanelCampos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCampos.setLayout(null);

        jLabel1.setText("Nome do Funcionario: *");
        jPanelCampos.add(jLabel1);
        jLabel1.setBounds(30, 20, 250, 20);
        jPanelCampos.add(jTextFieldNomeFuncionario);
        jTextFieldNomeFuncionario.setBounds(30, 40, 330, 20);

        jLabel2.setText("CPF: *");
        jPanelCampos.add(jLabel2);
        jLabel2.setBounds(390, 20, 120, 20);

        jLabel5.setText("Data de Admissão:");
        jPanelCampos.add(jLabel5);
        jLabel5.setBounds(30, 80, 360, 20);

        jLabel6.setText("Cargo: *");
        jPanelCampos.add(jLabel6);
        jLabel6.setBounds(390, 78, 140, 20);

        jPanelCampos.add(jComboBoxCargo);
        jComboBoxCargo.setBounds(390, 100, 220, 20);
        jPanelCampos.add(jFormattedTextFieldCpf);
        jFormattedTextFieldCpf.setBounds(390, 40, 100, 20);
        jPanelCampos.add(jFormattedTextFieldDataAdmissao);
        jFormattedTextFieldDataAdmissao.setBounds(30, 100, 100, 20);

        jLabel7.setText("Senha: *");
        jPanelCampos.add(jLabel7);
        jLabel7.setBounds(30, 140, 70, 20);

        jPasswordFieldSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldSenhaFocusLost(evt);
            }
        });
        jPanelCampos.add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(30, 160, 100, 20);

        jPanelFormulario.add(jPanelCampos);
        jPanelCampos.setBounds(10, 10, 790, 440);

        jTabbedPaneAbas.addTab("Formulário de Cadastro", jPanelFormulario);

        jPanelConsulta.setLayout(null);

        jPanelAcaoConsulta.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcaoConsulta.setLayout(null);

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanelAcaoConsulta.add(jButtonEditar);
        jButtonEditar.setBounds(30, 30, 120, 50);

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/trash.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanelAcaoConsulta.add(jButtonExcluir);
        jButtonExcluir.setBounds(180, 30, 120, 50);

        jButtonLimparConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clean.png"))); // NOI18N
        jButtonLimparConsulta.setText("Limpar");
        jButtonLimparConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparConsultaActionPerformed(evt);
            }
        });
        jPanelAcaoConsulta.add(jButtonLimparConsulta);
        jButtonLimparConsulta.setBounds(330, 30, 120, 50);

        jPanelConsulta.add(jPanelAcaoConsulta);
        jPanelAcaoConsulta.setBounds(10, 460, 790, 110);

        jPanelResultados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelResultados.setLayout(null);

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableFuncionarios);

        jPanelResultados.add(jScrollPane1);
        jScrollPane1.setBounds(30, 92, 730, 340);

        jLabel3.setText("Nome do Funcionário:");
        jPanelResultados.add(jLabel3);
        jLabel3.setBounds(30, 20, 230, 20);

        jLabel4.setText("Cargo:");
        jPanelResultados.add(jLabel4);
        jLabel4.setBounds(390, 20, 60, 20);
        jPanelResultados.add(jTextFieldNomeFuncionarioFiltro);
        jTextFieldNomeFuncionarioFiltro.setBounds(30, 40, 330, 20);

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanelResultados.add(jButtonPesquisar);
        jButtonPesquisar.setBounds(710, 23, 50, 40);

        jPanelResultados.add(jComboBoxCargoFiltro);
        jComboBoxCargoFiltro.setBounds(390, 40, 220, 20);

        jPanelConsulta.add(jPanelResultados);
        jPanelResultados.setBounds(10, 10, 790, 440);

        jTabbedPaneAbas.addTab("Consulta de Registros", jPanelConsulta);

        jPanelPrincipal.add(jTabbedPaneAbas);
        jTabbedPaneAbas.setBounds(0, 0, 810, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(816, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
        salvar();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed

        limparFormulario(jPanelFormulario);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed

        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed

        pesquisar();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        excluir();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonLimparConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparConsultaActionPerformed

        limparConsulta();
    }//GEN-LAST:event_jButtonLimparConsultaActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        
        editar();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jPasswordFieldSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaFocusLost

        try {
            validarSenha();
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }//GEN-LAST:event_jPasswordFieldSenhaFocusLost

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FuncionarioFrame().setVisible(true);
                } catch (PDVException ex) {
                    MensagemUtil.addMensagemErro(ex.getMessage());
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonLimparConsulta;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxCargo;
    private javax.swing.JComboBox jComboBoxCargoFiltro;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataAdmissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelAcaoConsulta;
    private javax.swing.JPanel jPanelAcaoFormulario;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneAbas;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldNomeFuncionario;
    private javax.swing.JTextField jTextFieldNomeFuncionarioFiltro;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método valida se a senha informada na tela é valida.
     */
    private void validarSenha() throws PDVException {
        String pass = new String(jPasswordFieldSenha.getPassword());
        if (pass.length() < 6 || pass.length() > 32) {
            throw new PDVException("Senha inválida! A senha deve conter no mínimo 6 e no máximo 32 dígitos.");
        }
    }
    
    /**
     * Este método percore os valores do banco de dados de cargos e popula a combobox.
     */
    private void preencherComboBoxCargo() {
        jComboBoxCargo.removeAllItems();
        jComboBoxCargo.addItem(".:: SELECIONE ::.");
        jComboBoxCargoFiltro.removeAllItems();
        jComboBoxCargoFiltro.addItem(".:: SELECIONE ::.");
        
        try {
            cargos = new CargoServico().consultar();
            for (Cargo cargo : cargos) {
                jComboBoxCargo.addItem(cargo.getNome());
                jComboBoxCargoFiltro.addItem(cargo.getNome());
            }
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    /**
     * Este método preenche a entidade de acordo com o preenchimento do formulário e o persiste.
     */
    @Override
    public void salvar() {
        try {
            validarSenha();
            preencherEntidade();
            
            getServico().salvar(getEntidade());
            addMensagemSalvoSucesso();
            
            limparFormulario(jPanelFormulario);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    /**
     * Este método obtem o registro selecionado e o exclui do banco de dados.
     */
    @Override
    public void excluir() {
        try {
            obterLinhaSelecionada();
            
            getServico().excluir(getEntidade());
            pesquisar();
            addMensagemExcluidoSucesso();
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    /**
     * Este método obtem o objeto selecionado na tabela e prepara o formulário para edição.
     */
    @Override
    public void editar() {
        try {
            obterLinhaSelecionada();
            
            jTabbedPaneAbas.setSelectedComponent(jPanelFormulario);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    /**
     * Este método pesquisa os registros do banco e exibe-os na JTable.
     */
    @Override
    public void pesquisar() {
        try {
            nome = jTextFieldNomeFuncionarioFiltro.getText();
            if (jComboBoxCargoFiltro.getSelectedIndex() > 0) {
                for (Cargo cargo : cargos) {
                    if (cargo.getNome().equals(jComboBoxCargoFiltro.getSelectedItem())) {
                        this.cargo = cargo;
                    }
                }
            }
            
            modeloTabela.setFuncionarios(getServico().consultarPor(nome, cargo));
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }
    
    /**
     * Este método verifica se os campos obrigatórios da tela foram preenchidos.
     */
    @Override
    public boolean isValidarCamposObrigatorios() {
        if (jTextFieldNomeFuncionario.getText().equals("") || jFormattedTextFieldCpf.getText().equals("   .   .   -  ")
                || jComboBoxCargo.getSelectedIndex() == 0 || new String(jPasswordFieldSenha.getPassword()).equals("")) {
            marcarCamposObrigatorios();
            throw new IllegalArgumentException("É necessário preencher os campos obrigatórios!");
        } else {
            return true;
        }
    }
    
    /**
     * Este método marca de vermelho os campos obrigatórios.
     */
    @Override
    public void marcarCamposObrigatorios() {
       jTextFieldNomeFuncionario.setBorder(FrameUtil.BORDA_VERMELHA);
       jFormattedTextFieldCpf.setBorder(FrameUtil.BORDA_VERMELHA);
       jComboBoxCargo.setBorder(FrameUtil.BORDA_VERMELHA);
       jPasswordFieldSenha.setBorder(FrameUtil.BORDA_VERMELHA);
    }
    
    /**
     * Este método limpa os campos do formulário.
     */
    @Override
    public void limparFormulario(Container formulario) {
        FrameUtil.limparCamposDoContainer(formulario);
        
        entidade = null;
        jTextFieldNomeFuncionario.setBorder(FrameUtil.BORDA_PADRAO);
        jFormattedTextFieldCpf.setBorder(FrameUtil.BORDA_PADRAO);
        jComboBoxCargo.setBorder(FrameUtil.BORDA_PADRAO);
        jPasswordFieldSenha.setBorder(FrameUtil.BORDA_PADRAO);
        
        jTextFieldNomeFuncionario.requestFocus();
    }
    
    /**
     * Este método limpa os campos da consulta.
     */
    @Override
    public void limparConsulta() {
        limparFormulario(jPanelResultados);
        modeloTabela.limparLista();
    }

    /**
     * Este método preenche a entidade Funcionario de acordo com os campos da tela.
     */
    @Override
    public void preencherEntidade() {
        if (isValidarCamposObrigatorios()) {
            getEntidade().setNome(jTextFieldNomeFuncionario.getText().toUpperCase());
            getEntidade().setCpf(jFormattedTextFieldCpf.getText());
            Date dataAdmissao = DateUtil.string2Date(jFormattedTextFieldDataAdmissao.getText());
            getEntidade().setDataAdmissao(dataAdmissao);
            
            // Só grava a senha caso seja um novo registro
            if (getEntidade().isTransient()) {
                getEntidade().setSenha(StringUtil.criptografar(new String(jPasswordFieldSenha.getPassword())));
            }
            
            for (Cargo cargo : cargos) {
                if (cargo.getNome().equals(jComboBoxCargo.getSelectedItem())) {
                    getEntidade().setCargo(cargo);
                    break;
                }
            }
        }
    }

    /**
     * Este método preenche o formulário de acordo com a entidade Funcionario.
     */
    @Override
    public void preencherFormulario(Funcionario funcionario) {
        if (funcionario != null) {
            jTextFieldNomeFuncionario.setText(funcionario.getNome());
            jFormattedTextFieldCpf.setText(funcionario.getCpf());
            jFormattedTextFieldDataAdmissao.setText(DateUtil.date2String(funcionario.getDataAdmissao()));
            jComboBoxCargo.setSelectedItem(funcionario.getCargo().getNome());
            jPasswordFieldSenha.setText(funcionario.getSenha());
        }
    }

    /**
     * Este método obtem a linha selecionada da JTable e preenche a entidade.
     */
    @Override
    public void obterLinhaSelecionada() {
        if(jTableFuncionarios.getSelectedRow() >= 0){
            int row = jTableFuncionarios.getSelectedRow();
        
            entidade = modeloTabela.getFuncionarios().get(row);
            preencherFormulario(entidade);
        } else {
            throw new IllegalArgumentException("É necessário selecionar algum registro na tabela antes de efetuar alguma ação!");
        }
    }
    
    /* GETTERS and SETTERS */
    
    public Funcionario getEntidade() {
        if (entidade == null) {
            entidade = new Funcionario();
        }
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public FuncionarioServico getServico() {
        if (servico == null) {
            try {
                servico = new FuncionarioServico();
            } catch (Exception ex) {
                addMensagemErro(ex.getMessage());
            }
        }
        return servico;
    }
}
