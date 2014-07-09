package br.com.devschool.produto.visao;

import br.com.devschool.entidade.Produto;
import br.com.devschool.entidade.UnidadeMedida;
import br.com.devschool.produto.servico.ProdutoServico;
import br.com.devschool.unidade_medida.servico.UnidadeMedidaServico;
import br.com.devschool.util.FrameUtil;
import br.com.devschool.util.MensagemUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.template.IFrame;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

/**
 * @author @atilla8huno
 */
public class ProdutoFrame extends FrameUtil implements IFrame<Produto> {

    private Produto entidade;
    private ProdutoServico servico;
    private ProdutoTableModel modeloTabela;
    private List<Produto> produtos;
    private List<UnidadeMedida> unidadeMedidas;
    
    /** Atributos de filtros */
    private String nome;
    private Integer codigo;
    
    /**
     * Método construtor
     */
    public ProdutoFrame() throws PDVException {
        initComponents();
        
        produtos = new ArrayList();
        unidadeMedidas = new ArrayList();
        modeloTabela = new ProdutoTableModel(produtos);
        jTableProdutos.setModel(modeloTabela);
        
        try {
            servico = new ProdutoServico();
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
        
        preencherComboBoxUnidadeMedida();
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
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigoProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValorProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxUnidadeMedidaProduto = new javax.swing.JComboBox();
        jPanelConsulta = new javax.swing.JPanel();
        jPanelAcaoConsulta = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonLimparConsulta = new javax.swing.JButton();
        jPanelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNomeProdutoFiltro = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldCodigoProdutoFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caso de Uso: Produto");
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

        jLabel1.setText("Nome do Produto: *");
        jPanelCampos.add(jLabel1);
        jLabel1.setBounds(30, 20, 250, 20);
        jPanelCampos.add(jTextFieldNomeProduto);
        jTextFieldNomeProduto.setBounds(30, 40, 330, 20);

        jLabel2.setText("Código: *");
        jPanelCampos.add(jLabel2);
        jLabel2.setBounds(390, 20, 110, 20);

        jTextFieldCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoProdutoKeyReleased(evt);
            }
        });
        jPanelCampos.add(jTextFieldCodigoProduto);
        jTextFieldCodigoProduto.setBounds(390, 40, 130, 20);

        jLabel5.setText("Valor: *");
        jPanelCampos.add(jLabel5);
        jLabel5.setBounds(30, 80, 360, 20);
        jPanelCampos.add(jTextFieldValorProduto);
        jTextFieldValorProduto.setBounds(30, 100, 100, 20);

        jLabel6.setText("Unidade de Medida: *");
        jPanelCampos.add(jLabel6);
        jLabel6.setBounds(390, 78, 140, 20);

        jPanelCampos.add(jComboBoxUnidadeMedidaProduto);
        jComboBoxUnidadeMedidaProduto.setBounds(390, 100, 220, 20);

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

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProdutos);

        jPanelResultados.add(jScrollPane1);
        jScrollPane1.setBounds(30, 92, 730, 340);

        jLabel3.setText("Nome do Produto:");
        jPanelResultados.add(jLabel3);
        jLabel3.setBounds(30, 20, 230, 20);

        jLabel4.setText("Código:");
        jPanelResultados.add(jLabel4);
        jLabel4.setBounds(390, 20, 60, 20);
        jPanelResultados.add(jTextFieldNomeProdutoFiltro);
        jTextFieldNomeProdutoFiltro.setBounds(30, 40, 330, 20);

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanelResultados.add(jButtonPesquisar);
        jButtonPesquisar.setBounds(710, 23, 50, 40);

        jTextFieldCodigoProdutoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoProdutoFiltroKeyReleased(evt);
            }
        });
        jPanelResultados.add(jTextFieldCodigoProdutoFiltro);
        jTextFieldCodigoProdutoFiltro.setBounds(390, 40, 110, 20);

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

    private void jTextFieldCodigoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoProdutoKeyReleased

    }//GEN-LAST:event_jTextFieldCodigoProdutoKeyReleased

    private void jTextFieldCodigoProdutoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoProdutoFiltroKeyReleased

    }//GEN-LAST:event_jTextFieldCodigoProdutoFiltroKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProdutoFrame().setVisible(true);
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
    private javax.swing.JComboBox jComboBoxUnidadeMedidaProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelAcaoConsulta;
    private javax.swing.JPanel jPanelAcaoFormulario;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelConsulta;
    private javax.swing.JPanel jPanelFormulario;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneAbas;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldCodigoProdutoFiltro;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldNomeProdutoFiltro;
    private javax.swing.JTextField jTextFieldValorProduto;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método percore os valores do banco de dados de unidade de medida e popula a combobox.
     */
    private void preencherComboBoxUnidadeMedida() {
        jComboBoxUnidadeMedidaProduto.removeAllItems();
        jComboBoxUnidadeMedidaProduto.addItem(".:: SELECIONE ::.");
        
        try {
            unidadeMedidas = new UnidadeMedidaServico().consultar();
            for (UnidadeMedida unidade : unidadeMedidas) {
                jComboBoxUnidadeMedidaProduto.addItem(unidade.getDescricao());
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
            nome = jTextFieldNomeProdutoFiltro.getText();
            codigo = !jTextFieldCodigoProdutoFiltro.getText().equals("") ? Integer.parseInt(jTextFieldCodigoProdutoFiltro.getText()) : 0;
            
            modeloTabela.setProdutos(getServico().consultarPor(nome, codigo));
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }
    
    /**
     * Este método verifica se os campos obrigatórios da tela foram preenchidos.
     */
    @Override
    public boolean isValidarCamposObrigatorios() {
        if (jTextFieldNomeProduto.getText().equals("") || jTextFieldCodigoProduto.getText().equals("")
                || jComboBoxUnidadeMedidaProduto.getSelectedIndex() == 0 || jTextFieldValorProduto.getText().equals("")) {
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
       jTextFieldNomeProduto.setBorder(FrameUtil.BORDA_VERMELHA);
       jTextFieldCodigoProduto.setBorder(FrameUtil.BORDA_VERMELHA);
       jTextFieldValorProduto.setBorder(FrameUtil.BORDA_VERMELHA);
       jComboBoxUnidadeMedidaProduto.setBorder(FrameUtil.BORDA_VERMELHA);
    }
    
    /**
     * Este método limpa os campos do formulário.
     */
    @Override
    public void limparFormulario(Container formulario) {
        FrameUtil.limparCamposDoContainer(formulario);
        
        entidade = null;
        jTextFieldNomeProduto.setBorder(FrameUtil.BORDA_PADRAO);
        jTextFieldCodigoProduto.setBorder(FrameUtil.BORDA_PADRAO);
        jTextFieldValorProduto.setBorder(FrameUtil.BORDA_PADRAO);
        jComboBoxUnidadeMedidaProduto.setBorder(FrameUtil.BORDA_PADRAO);
        
        jTextFieldNomeProduto.requestFocus();
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
     * Este método preenche a entidade Produto de acordo com os campos da tela.
     */
    @Override
    public void preencherEntidade() {
        if (isValidarCamposObrigatorios()) {
            getEntidade().setNome(jTextFieldNomeProduto.getText().toUpperCase());
            getEntidade().setCodigo(Integer.parseInt(jTextFieldCodigoProduto.getText()));
            getEntidade().setValor(Double.parseDouble(jTextFieldValorProduto.getText()));
            
            for (UnidadeMedida unidade : unidadeMedidas) {
                if (unidade.getDescricao().equals(jComboBoxUnidadeMedidaProduto.getSelectedItem())) {
                    getEntidade().setUnidadeMedida(unidade);
                    break;
                }
            }
        }
    }

    /**
     * Este método preenche o formulário de acordo com a entidade Produto.
     */
    @Override
    public void preencherFormulario(Produto produto) {
        if (produto != null) {
            jTextFieldNomeProduto.setText(produto.getNome());
            jTextFieldCodigoProduto.setText(produto.getCodigo().toString());
            jTextFieldValorProduto.setText(produto.getValor().toString());
            jComboBoxUnidadeMedidaProduto.setSelectedItem(produto.getUnidadeMedida().getDescricao());
        }
    }

    /**
     * Este método obtem a linha selecionada da JTable e preenche a entidade.
     */
    @Override
    public void obterLinhaSelecionada() {
        if(jTableProdutos.getSelectedRow() >= 0){
            int row = jTableProdutos.getSelectedRow();
        
            entidade = modeloTabela.getProdutos().get(row);
            preencherFormulario(entidade);
        } else {
            throw new IllegalArgumentException("É necessário selecionar algum registro na tabela antes de efetuar alguma ação!");
        }
    }
    
    /* GETTERS and SETTERS */
    
    public Produto getEntidade() {
        if (entidade == null) {
            entidade = new Produto();
        }
        return entidade;
    }

    public void setEntidade(Produto entidade) {
        this.entidade = entidade;
    }

    public ProdutoServico getServico() {
        if (servico == null) {
            try {
                servico = new ProdutoServico();
            } catch (Exception ex) {
                addMensagemErro(ex.getMessage());
            }
        }
        return servico;
    }
}
