package br.com.devschool.venda.visao;

import br.com.devschool.entidade.FormaPagamento;
import br.com.devschool.entidade.Produto;
import br.com.devschool.entidade.Venda;
import br.com.devschool.entidade.VendaFormaPagamento;
import br.com.devschool.entidade.VendaProduto;
import br.com.devschool.forma_pagamento.servico.FormaPagamentoServico;
import br.com.devschool.produto.servico.ProdutoServico;
import br.com.devschool.util.FrameUtil;
import br.com.devschool.util.MensagemUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.util.enumerador.PerfilEnum;
import br.com.devschool.util.template.IFrame;
import br.com.devschool.venda.servico.VendaServico;
import java.awt.Container;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author ATILLA
 */
public class VendaFrame extends FrameUtil implements IFrame<Venda> {

    private VendaProduto vendaProduto = null;
    private VendaFormaPagamento vendaPagamento = null;
    private Venda venda = null;
    private Produto produto = null;
    private FormaPagamento pagamento = null;
    private ProdutoServico produtoServico;
    private VendaServico servico;
    private List<VendaProduto> produtos;
    private List<VendaFormaPagamento> pagamentos;
    private VendaProdutoTableModel produtoModel;
    private VendaPagamentoTableModel pagamentoModel;
    
    private List<FormaPagamento> formasPagamentos;

    public VendaFrame() throws PDVException {
        initComponents();
        
        verificarTerminal();

        produtos = new ArrayList();
        pagamentos = new ArrayList();
        formasPagamentos = new ArrayList();

        produtoModel = new VendaProdutoTableModel(produtos);
        pagamentoModel = new VendaPagamentoTableModel(pagamentos);

        jTableProdutos.setModel(produtoModel);
        jTablePagamentos.setModel(pagamentoModel);

        try {
            servico = new VendaServico();
            produtoServico = new ProdutoServico();
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }

        preencherComboBoxFormaPagamento();
        novaVenda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jTabbedPaneVenda = new javax.swing.JTabbedPane();
        jPanelVenda = new javax.swing.JPanel();
        jPanelAcoesFormulario = new javax.swing.JPanel();
        jButtonNovaVenda = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanelFormularioProdutos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSubtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanelNovoProduto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigoProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUnidadeMedida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonRemoverItem = new javax.swing.JButton();
        jButtonAplicaDesconto = new javax.swing.JButton();
        jPanelPagamento = new javax.swing.JPanel();
        jPanelFormularioPagamento = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePagamentos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTotalTroco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTotalPago = new javax.swing.JTextField();
        jTextFieldTotalVenda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButtonRemoverPagamento = new javax.swing.JButton();
        jPanelNovoPagamento = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldValorPagamento = new javax.swing.JTextField();
        jComboBoxFormaPagamento = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jButtonEfetuarPagamento = new javax.swing.JButton();
        jPanelAcoesPagamento = new javax.swing.JPanel();
        jButtonFecharPagamento = new javax.swing.JButton();
        jPanelEntrega = new javax.swing.JPanel();
        jPanelFormularioEntrega = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldContatoCliente = new javax.swing.JTextField();
        jTextFieldEnderecoCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCheckBoxEntregaDomicilio = new javax.swing.JCheckBox();
        jPanelAcoesEntrega = new javax.swing.JPanel();
        jButtonFecharEntrega = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caso de Uso: Venda");
        setResizable(false);

        jPanelPrincipal.setLayout(null);

        jPanelVenda.setLayout(null);

        jPanelAcoesFormulario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcoesFormulario.setLayout(null);

        jButtonNovaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clean.png"))); // NOI18N
        jButtonNovaVenda.setText("Nova");
        jButtonNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendaActionPerformed(evt);
            }
        });
        jPanelAcoesFormulario.add(jButtonNovaVenda);
        jButtonNovaVenda.setBounds(180, 30, 120, 50);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/disk.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanelAcoesFormulario.add(jButtonSalvar);
        jButtonSalvar.setBounds(30, 30, 120, 50);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        jPanelAcoesFormulario.add(jButtonFechar);
        jButtonFechar.setBounds(640, 30, 120, 50);

        jPanelVenda.add(jPanelAcoesFormulario);
        jPanelAcoesFormulario.setBounds(10, 460, 780, 110);

        jPanelFormularioProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFormularioProdutos.setLayout(null);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableProdutos);

        jPanelFormularioProdutos.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 650, 340);

        jLabel6.setText("Subtotal:");
        jPanelFormularioProdutos.add(jLabel6);
        jLabel6.setBounds(670, 390, 80, 20);

        jTextFieldSubtotal.setEnabled(false);
        jPanelFormularioProdutos.add(jTextFieldSubtotal);
        jTextFieldSubtotal.setBounds(670, 410, 100, 20);

        jLabel7.setText("Carrinho de Compras:");
        jPanelFormularioProdutos.add(jLabel7);
        jLabel7.setBounds(10, 70, 160, 20);

        jPanelNovoProduto.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNovoProduto.setLayout(null);

        jLabel1.setText("Código do Produto:");
        jPanelNovoProduto.add(jLabel1);
        jLabel1.setBounds(10, 10, 110, 20);

        jTextFieldCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoProdutoFocusLost(evt);
            }
        });
        jPanelNovoProduto.add(jTextFieldCodigoProduto);
        jTextFieldCodigoProduto.setBounds(10, 30, 90, 20);

        jLabel2.setText("Nome do Produto:");
        jPanelNovoProduto.add(jLabel2);
        jLabel2.setBounds(120, 10, 110, 20);

        jTextFieldNomeProduto.setEnabled(false);
        jPanelNovoProduto.add(jTextFieldNomeProduto);
        jTextFieldNomeProduto.setBounds(120, 30, 290, 20);

        jLabel3.setText("Unid. Medida:");
        jPanelNovoProduto.add(jLabel3);
        jLabel3.setBounds(430, 10, 100, 20);

        jTextFieldUnidadeMedida.setEnabled(false);
        jPanelNovoProduto.add(jTextFieldUnidadeMedida);
        jTextFieldUnidadeMedida.setBounds(430, 30, 70, 20);

        jLabel4.setText("Valor Unitário:");
        jPanelNovoProduto.add(jLabel4);
        jLabel4.setBounds(520, 10, 80, 20);

        jTextFieldValorUnitario.setEnabled(false);
        jPanelNovoProduto.add(jTextFieldValorUnitario);
        jTextFieldValorUnitario.setBounds(520, 30, 80, 20);

        jLabel5.setText("Qtde.:");
        jPanelNovoProduto.add(jLabel5);
        jLabel5.setBounds(620, 10, 40, 20);

        jTextFieldQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQuantidadeFocusLost(evt);
            }
        });
        jPanelNovoProduto.add(jTextFieldQuantidade);
        jTextFieldQuantidade.setBounds(620, 30, 40, 20);

        jPanelFormularioProdutos.add(jPanelNovoProduto);
        jPanelNovoProduto.setBounds(0, 0, 780, 70);

        jButtonRemoverItem.setText("Remover");
        jButtonRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverItemActionPerformed(evt);
            }
        });
        jPanelFormularioProdutos.add(jButtonRemoverItem);
        jButtonRemoverItem.setBounds(670, 130, 100, 30);

        jButtonAplicaDesconto.setText("Desconto");
        jButtonAplicaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAplicaDescontoActionPerformed(evt);
            }
        });
        jPanelFormularioProdutos.add(jButtonAplicaDesconto);
        jButtonAplicaDesconto.setBounds(670, 90, 100, 30);

        jPanelVenda.add(jPanelFormularioProdutos);
        jPanelFormularioProdutos.setBounds(10, 10, 780, 440);

        jTabbedPaneVenda.addTab("Venda", jPanelVenda);

        jPanelPagamento.setLayout(null);

        jPanelFormularioPagamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFormularioPagamento.setLayout(null);

        jTablePagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTablePagamentos);

        jPanelFormularioPagamento.add(jScrollPane2);
        jScrollPane2.setBounds(10, 92, 650, 340);

        jLabel12.setText("Pagamentos:");
        jPanelFormularioPagamento.add(jLabel12);
        jLabel12.setBounds(10, 70, 160, 20);

        jLabel13.setText("Total do Troco:");
        jPanelFormularioPagamento.add(jLabel13);
        jLabel13.setBounds(670, 390, 100, 20);

        jTextFieldTotalTroco.setEnabled(false);
        jPanelFormularioPagamento.add(jTextFieldTotalTroco);
        jTextFieldTotalTroco.setBounds(670, 410, 100, 20);

        jLabel14.setText("Total Pago:");
        jPanelFormularioPagamento.add(jLabel14);
        jLabel14.setBounds(670, 340, 100, 20);

        jTextFieldTotalPago.setEnabled(false);
        jPanelFormularioPagamento.add(jTextFieldTotalPago);
        jTextFieldTotalPago.setBounds(670, 360, 100, 20);

        jTextFieldTotalVenda.setEnabled(false);
        jPanelFormularioPagamento.add(jTextFieldTotalVenda);
        jTextFieldTotalVenda.setBounds(670, 310, 100, 20);

        jLabel15.setText("Total da Venda:");
        jPanelFormularioPagamento.add(jLabel15);
        jLabel15.setBounds(670, 290, 100, 20);

        jButtonRemoverPagamento.setText("Remover");
        jButtonRemoverPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPagamentoActionPerformed(evt);
            }
        });
        jPanelFormularioPagamento.add(jButtonRemoverPagamento);
        jButtonRemoverPagamento.setBounds(670, 90, 100, 30);

        jPanelNovoPagamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNovoPagamento.setLayout(null);

        jLabel16.setText("Valor do Pagamento:");
        jPanelNovoPagamento.add(jLabel16);
        jLabel16.setBounds(310, 10, 110, 20);

        jTextFieldValorPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValorPagamentoFocusLost(evt);
            }
        });
        jPanelNovoPagamento.add(jTextFieldValorPagamento);
        jTextFieldValorPagamento.setBounds(310, 30, 110, 20);

        jPanelNovoPagamento.add(jComboBoxFormaPagamento);
        jComboBoxFormaPagamento.setBounds(10, 30, 280, 20);

        jLabel17.setText("Forma de Pagamento:");
        jPanelNovoPagamento.add(jLabel17);
        jLabel17.setBounds(10, 10, 150, 20);

        jButtonEfetuarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        jButtonEfetuarPagamento.setText("Pagar");
        jButtonEfetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEfetuarPagamentoActionPerformed(evt);
            }
        });
        jPanelNovoPagamento.add(jButtonEfetuarPagamento);
        jButtonEfetuarPagamento.setBounds(670, 10, 100, 40);

        jPanelFormularioPagamento.add(jPanelNovoPagamento);
        jPanelNovoPagamento.setBounds(0, 0, 780, 70);

        jPanelPagamento.add(jPanelFormularioPagamento);
        jPanelFormularioPagamento.setBounds(10, 10, 780, 440);

        jPanelAcoesPagamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcoesPagamento.setLayout(null);

        jButtonFecharPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButtonFecharPagamento.setText("Fechar");
        jButtonFecharPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharPagamentoActionPerformed(evt);
            }
        });
        jPanelAcoesPagamento.add(jButtonFecharPagamento);
        jButtonFecharPagamento.setBounds(640, 30, 120, 50);

        jPanelPagamento.add(jPanelAcoesPagamento);
        jPanelAcoesPagamento.setBounds(10, 460, 780, 110);

        jTabbedPaneVenda.addTab("Pagamento", jPanelPagamento);

        jPanelEntrega.setLayout(null);

        jPanelFormularioEntrega.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFormularioEntrega.setLayout(null);

        jLabel8.setText("Nome do Cliente:");
        jPanelFormularioEntrega.add(jLabel8);
        jLabel8.setBounds(10, 10, 110, 20);

        jTextFieldNomeCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNomeClienteFocusLost(evt);
            }
        });
        jPanelFormularioEntrega.add(jTextFieldNomeCliente);
        jTextFieldNomeCliente.setBounds(10, 30, 340, 20);

        jLabel9.setText("Contato do Cliente:");
        jPanelFormularioEntrega.add(jLabel9);
        jLabel9.setBounds(390, 10, 110, 20);

        jTextFieldContatoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldContatoClienteFocusLost(evt);
            }
        });
        jPanelFormularioEntrega.add(jTextFieldContatoCliente);
        jTextFieldContatoCliente.setBounds(390, 30, 340, 20);

        jTextFieldEnderecoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEnderecoClienteFocusLost(evt);
            }
        });
        jPanelFormularioEntrega.add(jTextFieldEnderecoCliente);
        jTextFieldEnderecoCliente.setBounds(10, 90, 340, 20);

        jLabel10.setText("Endereço do Cliente:");
        jPanelFormularioEntrega.add(jLabel10);
        jLabel10.setBounds(10, 70, 110, 20);

        jLabel11.setText("Entrega a Domicílio?");
        jPanelFormularioEntrega.add(jLabel11);
        jLabel11.setBounds(390, 70, 110, 20);
        jPanelFormularioEntrega.add(jCheckBoxEntregaDomicilio);
        jCheckBoxEntregaDomicilio.setBounds(390, 90, 340, 21);

        jPanelEntrega.add(jPanelFormularioEntrega);
        jPanelFormularioEntrega.setBounds(10, 10, 780, 440);

        jPanelAcoesEntrega.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcoesEntrega.setLayout(null);

        jButtonFecharEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButtonFecharEntrega.setText("Fechar");
        jButtonFecharEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharEntregaActionPerformed(evt);
            }
        });
        jPanelAcoesEntrega.add(jButtonFecharEntrega);
        jButtonFecharEntrega.setBounds(640, 30, 120, 50);

        jPanelEntrega.add(jPanelAcoesEntrega);
        jPanelAcoesEntrega.setBounds(10, 460, 780, 110);

        jTabbedPaneVenda.addTab("Entrega", jPanelEntrega);

        jPanelPrincipal.add(jTabbedPaneVenda);
        jTabbedPaneVenda.setBounds(0, 0, 800, 600);

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

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoProdutoFocusLost

        consultarProdutoPorCodigo();
    }//GEN-LAST:event_jTextFieldCodigoProdutoFocusLost

    private void jTextFieldQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeFocusLost

        addProduto();
    }//GEN-LAST:event_jTextFieldQuantidadeFocusLost

    private void jButtonNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaVendaActionPerformed

        novaVenda();
    }//GEN-LAST:event_jButtonNovaVendaActionPerformed

    private void jButtonAplicaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAplicaDescontoActionPerformed

        aplicarDesconto();
    }//GEN-LAST:event_jButtonAplicaDescontoActionPerformed

    private void jButtonRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverItemActionPerformed

        removerItem();
    }//GEN-LAST:event_jButtonRemoverItemActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        salvar();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed

        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonFecharPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharPagamentoActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButtonFecharPagamentoActionPerformed

    private void jButtonFecharEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharEntregaActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButtonFecharEntregaActionPerformed

    private void jTextFieldNomeClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeClienteFocusLost

    private void jTextFieldContatoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldContatoClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContatoClienteFocusLost

    private void jTextFieldEnderecoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoClienteFocusLost

    private void jButtonRemoverPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPagamentoActionPerformed

        removerPagamento();
    }//GEN-LAST:event_jButtonRemoverPagamentoActionPerformed

    private void jTextFieldValorPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValorPagamentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorPagamentoFocusLost

    private void jButtonEfetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEfetuarPagamentoActionPerformed

        addPagamento();
    }//GEN-LAST:event_jButtonEfetuarPagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(VendaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VendaFrame().setVisible(true);
                } catch (PDVException ex) {
                    MensagemUtil.addMensagemErro(ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAplicaDesconto;
    private javax.swing.JButton jButtonEfetuarPagamento;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonFecharEntrega;
    private javax.swing.JButton jButtonFecharPagamento;
    private javax.swing.JButton jButtonNovaVenda;
    private javax.swing.JButton jButtonRemoverItem;
    private javax.swing.JButton jButtonRemoverPagamento;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxEntregaDomicilio;
    private javax.swing.JComboBox jComboBoxFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAcoesEntrega;
    private javax.swing.JPanel jPanelAcoesFormulario;
    private javax.swing.JPanel jPanelAcoesPagamento;
    private javax.swing.JPanel jPanelEntrega;
    private javax.swing.JPanel jPanelFormularioEntrega;
    private javax.swing.JPanel jPanelFormularioPagamento;
    private javax.swing.JPanel jPanelFormularioProdutos;
    private javax.swing.JPanel jPanelNovoPagamento;
    private javax.swing.JPanel jPanelNovoProduto;
    private javax.swing.JPanel jPanelPagamento;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneVenda;
    private javax.swing.JTable jTablePagamentos;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldContatoCliente;
    private javax.swing.JTextField jTextFieldEnderecoCliente;
    private javax.swing.JTextField jTextFieldNomeCliente;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldSubtotal;
    private javax.swing.JTextField jTextFieldTotalPago;
    private javax.swing.JTextField jTextFieldTotalTroco;
    private javax.swing.JTextField jTextFieldTotalVenda;
    private javax.swing.JTextField jTextFieldUnidadeMedida;
    private javax.swing.JTextField jTextFieldValorPagamento;
    private javax.swing.JTextField jTextFieldValorUnitario;
    // End of variables declaration//GEN-END:variables

    /**
     * Pode efetuar uma auditoria ou algo semelhante aqui...
     */
    private void cancelarVenda() {
        novaVenda();
    }

    private void consultarProdutoPorCodigo() {
        if (jTextFieldCodigoProduto.getText().equals("")) {
            limparProduto();
            return;
        }

        try {
            Integer codigo = Integer.parseInt(jTextFieldCodigoProduto.getText());
            produto = produtoServico.consultarPorCodigo(codigo);

            if (produto == null || produto.isTransient()) {
                addMensagemAviso("Produto inexistente!");
                jTextFieldCodigoProduto.requestFocus();
            } else {
                jTextFieldNomeProduto.setText(produto.getNome());
                jTextFieldUnidadeMedida.setText(produto.getUnidadeMedida().getSigla());
                jTextFieldValorUnitario.setText(NumberFormat.getCurrencyInstance().format(produto.getValor()));
            }
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }
    }

    private void addProduto() {
        if (jTextFieldQuantidade.getText().equals("")) {
            limparProduto();
            jTextFieldCodigoProduto.requestFocus();
            return;
        }

        try {
            VendaProduto vendaProduto = new VendaProduto();
            vendaProduto.setProduto(produto);
            vendaProduto.setQuantidade(Double.parseDouble(jTextFieldQuantidade.getText()));
            vendaProduto.setValor(produto.getValor());
            vendaProduto.setVenda(venda);

            produtos.add(vendaProduto);
            produtoModel.setVendaProdutos(produtos);

            atualizarPagamentos();
            limparProduto();
            jTextFieldCodigoProduto.requestFocus();
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }
    
    private void limparProduto() {
        produto = null;
        limparCamposDoContainer(jPanelNovoProduto);
    }
    
    private void limparPagamento() {
        pagamento = null;
        jComboBoxFormaPagamento.setSelectedIndex(0);
        jTextFieldValorPagamento.setText("");
    }
    
    private void novaVenda() {
        limparTudo();
        
        vendaProduto = null;
        vendaPagamento = null;
        produto = null;
        pagamento = null;
        
        try {
            verificarTerminal();
            venda = new Venda();
            venda.setId(servico.consultarProximoId());
            venda.setTerminal(FrameUtil.TERMINAL_LOGADO);
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }
    }

    private void fecharVenda() throws PDVException {
        verificarTerminal();
        verificarCarrinhoCompra();
        verificarPagamento();
        
        venda.setDataCadastro(Calendar.getInstance().getTime());
        venda.setPagamentos(pagamentos);
        venda.setProdutos(produtos);
        venda.setValorPago(getValorPago());
        venda.setValorTotal(getValorTotal());
        venda.setValorTroco(getValorTroco());
        venda.setNomeCliente(jTextFieldNomeCliente.getText());
        venda.setEntregaDomicilio(jCheckBoxEntregaDomicilio.isSelected());
        venda.setEnderecoCliente(jTextFieldEnderecoCliente.getText());
        venda.setContatoCliente(jTextFieldContatoCliente.getText());
        
        servico.salvar(venda);
    }
    
    private void removerItem() {
        try {
            obterProdutoSelecionado();
            produtos.remove(vendaProduto);
            produtoModel.setVendaProdutos(produtos);

            atualizarPagamentos();
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }
    
    private void removerPagamento() {
        try {
            obterPagamentoSelecionado();
            pagamentos.remove(vendaPagamento);
            pagamentoModel.setVendaFormaPagamentos(pagamentos);

            atualizarPagamentos();
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }

    private void obterProdutoSelecionado() {
        if (jTableProdutos.getSelectedRow() >= 0) {
            int row = jTableProdutos.getSelectedRow();

            vendaProduto = produtoModel.getVendaProdutos().get(row);
        } else {
            throw new IllegalArgumentException("É necessário selecionar algum registro na tabela antes de efetuar alguma ação!");
        }
    }
    
    private void obterPagamentoSelecionado() {
        if (jTablePagamentos.getSelectedRow() >= 0) {
            int row = jTablePagamentos.getSelectedRow();

            vendaPagamento = pagamentoModel.getVendaFormaPagamentos().get(row);
        } else {
            throw new IllegalArgumentException("É necessário selecionar algum registro na tabela antes de efetuar alguma ação!");
        }
    }

    private void aplicarDesconto() {
        try {
            obterProdutoSelecionado();
            Double desconto = Double.parseDouble(
                    JOptionPane.showInputDialog("Informe a porcentagem do desconto a ser aplicado:"));

            if (desconto < 0.00 || desconto > 100.00) {
                throw new IllegalArgumentException("Desconto inválido!");
            } else {
                vendaProduto.setDesconto(desconto);
                // produtos.set(jTableProdutos.getSelectedRow(), vendaProduto);
                produtoModel.refresh();

                atualizarPagamentos();
            }
        } catch (NumberFormatException e) {
            addMensagemErro("Valor inválido!");
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }

    @Override
    public boolean isValidarCamposObrigatorios() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void marcarCamposObrigatorios() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void preencherEntidade() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void preencherFormulario(Venda t) {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void obterLinhaSelecionada() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void limparFormulario(Container formulario) {
        limparCamposDoContainer(formulario);
    }

    private void limparTudo() {
        limparCamposDoContainer(jPanelVenda);
        limparCamposDoContainer(jPanelEntrega);
        limparCamposDoContainer(jPanelPagamento);
        
        produtoModel.limpar();
        pagamentoModel.limpar();
        
        pagamentos = new ArrayList();
        produtos = new ArrayList();
    }

    @Override
    public void limparConsulta() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void salvar() {
        try {
            fecharVenda();
            addMensagemInfo("Venda finalizada com sucesso!");
            novaVenda();
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void editar() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    @Override
    public void pesquisar() {
        throw new UnsupportedOperationException("Não suportado por enquanto.");
    }

    private void verificarPagamento() throws PDVException {
        Double valorPago = 0.00;
        for (VendaFormaPagamento pagamento : pagamentos) {
            valorPago += pagamento.getValor();
        }
        
        if (valorPago < getValorTotal()) {
            String valorPagoReal = NumberFormat.getCurrencyInstance().format(valorPago);
            String valorTotalReal = NumberFormat.getCurrencyInstance().format(getValorTotal());
            
            // Verificação necessária para casos de arredondamento.
            if (!valorPagoReal.equals(valorTotalReal)) {
                throw new PDVException("Pagamento não está completo. Impossível finalizar a venda!");
            }
        }
    }

    private Double getSubtotalDaVenda() {
        Double subtotal = 0.00;
        for (VendaProduto vendaProduto : produtos) {
            subtotal += vendaProduto.calculaSubtotal();
        }
        return subtotal;
    }
    
    private Double getValorTotal() {
        return getSubtotalDaVenda();
    }

    private Double getValorPago() {
        Double valorPago = 0.00;
        for (VendaFormaPagamento vendaFormaPagamento : pagamentos) {
            valorPago += vendaFormaPagamento.getValor();
        }
        return valorPago;
    }

    private Double getValorTroco() {
        return (getValorPago() - getValorTotal()) < 0.00 ? 0.00 : (getValorPago() - getValorTotal());
    }

    private void verificarTerminal() throws PDVException {
        if (!FrameUtil.FUNCIONARIO_LOGADO.getCargo().getPerfil().equals(PerfilEnum.ATENDENTE.getNome())
                && !FrameUtil.FUNCIONARIO_LOGADO.getCargo().getPerfil().equals(PerfilEnum.SUPERVISOR.getNome())) {
            throw new PDVException("O usuário logado não pode finalizar uma venda! [PERFIL INVÁLIDO]");
        }
    }

    private void atualizarPagamentos() {
        jTextFieldSubtotal.setText(NumberFormat.getCurrencyInstance().format(getSubtotalDaVenda()));
        jTextFieldTotalVenda.setText(NumberFormat.getCurrencyInstance().format(getValorTotal()));
        jTextFieldTotalTroco.setText(NumberFormat.getCurrencyInstance().format(getValorTroco()));
        jTextFieldTotalPago.setText(NumberFormat.getCurrencyInstance().format(getValorPago()));
    }
    
    private void addPagamento() {
        if (jTextFieldValorPagamento.getText().equals("") || jComboBoxFormaPagamento.getSelectedIndex() == 0) {
            addMensagemAviso("É necessário preencher todos os pagamentos para efetuar um pagamento.");
            jTextFieldValorPagamento.requestFocus();
            return;
        }

        try {
            VendaFormaPagamento vendaFormaPagamento = new VendaFormaPagamento();
            vendaFormaPagamento.setValor(Double.parseDouble(jTextFieldValorPagamento.getText()));
            vendaFormaPagamento.setVenda(venda);
            
            for (FormaPagamento forma : formasPagamentos) {
                if (forma.getDescricao().equals(jComboBoxFormaPagamento.getSelectedItem())) {
                    vendaFormaPagamento.setFormaPagamento(forma);
                    break;
                }
            }

            pagamentos.add(vendaFormaPagamento);
            pagamentoModel.setVendaFormaPagamentos(pagamentos);

            atualizarPagamentos();
            limparPagamento();
            jComboBoxFormaPagamento.requestFocus();
        } catch (NumberFormatException e) {
            addMensagemErro("Valor do pagamento inválido. Verifique!!!");
        }
    }

    private void verificarCarrinhoCompra() throws PDVException {
        if (produtos == null || produtos.isEmpty()) {
            throw new PDVException("Nenhum produto no carrinho. Impossível finalizar a venda!");
        }
    }

    private void preencherComboBoxFormaPagamento() {
        jComboBoxFormaPagamento.removeAllItems();
        jComboBoxFormaPagamento.addItem(".:: SELECIONE ::.");
        
        try {
            formasPagamentos = new FormaPagamentoServico().consultar();
            for (FormaPagamento forma : formasPagamentos) {
                jComboBoxFormaPagamento.addItem(forma.getDescricao());
            }
        } catch (PDVException ex) {
            addMensagemErro(ex.getMessage());
        }
    }
}
