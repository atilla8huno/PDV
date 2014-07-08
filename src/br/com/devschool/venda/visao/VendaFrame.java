package br.com.devschool.venda.visao;

import br.com.devschool.entidade.Produto;
import br.com.devschool.entidade.Venda;
import br.com.devschool.entidade.VendaFormaPagamento;
import br.com.devschool.entidade.VendaProduto;
import br.com.devschool.produto.servico.ProdutoServico;
import br.com.devschool.util.FrameUtil;
import br.com.devschool.util.MensagemUtil;
import br.com.devschool.util.PDVException;
import br.com.devschool.venda.servico.VendaServico;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author ATILLA
 */
public class VendaFrame extends FrameUtil {

    private VendaProduto vendaProduto = null;
    private Venda venda = null;
    private Produto produto = null;
    private ProdutoServico produtoServico;
    private VendaServico servico;
    private List<VendaProduto> produtos;
    private List<VendaFormaPagamento> pagamentos;
    private VendaProdutoTableModel produtoModel;
    private VendaPagamentoTableModel pagamentoModel;

    public VendaFrame() throws PDVException {
        initComponents();

        produtos = new ArrayList();
        pagamentos = new ArrayList();

        produtoModel = new VendaProdutoTableModel(produtos);
        pagamentoModel = new VendaPagamentoTableModel(pagamentos);

        jTableProdutos.setModel(produtoModel);

        try {
            servico = new VendaServico();
            produtoServico = new ProdutoServico();
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }

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
        jPanelAcoesPagamento = new javax.swing.JPanel();
        jPanelEntrega = new javax.swing.JPanel();
        jPanelFormularioEntrega = new javax.swing.JPanel();
        jPanelAcoesEntrega = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caso de Uso: Venda");
        setResizable(false);

        jPanelPrincipal.setLayout(null);

        jPanelVenda.setLayout(null);

        jPanelAcoesFormulario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAcoesFormulario.setLayout(null);

        jButtonNovaVenda.setText("Nova Venda");
        jButtonNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaVendaActionPerformed(evt);
            }
        });
        jPanelAcoesFormulario.add(jButtonNovaVenda);
        jButtonNovaVenda.setBounds(20, 30, 150, 40);

        jPanelVenda.add(jPanelAcoesFormulario);
        jPanelAcoesFormulario.setBounds(10, 460, 770, 100);

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
        jScrollPane1.setBounds(10, 90, 650, 310);

        jLabel6.setText("Subtotal:");
        jPanelFormularioProdutos.add(jLabel6);
        jLabel6.setBounds(520, 410, 80, 20);

        jTextFieldSubtotal.setEnabled(false);
        jPanelFormularioProdutos.add(jTextFieldSubtotal);
        jTextFieldSubtotal.setBounds(580, 410, 80, 20);

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
        jTextFieldNomeProduto.setBounds(120, 30, 260, 20);

        jLabel3.setText("Unid. Medida:");
        jPanelNovoProduto.add(jLabel3);
        jLabel3.setBounds(400, 10, 100, 20);

        jTextFieldUnidadeMedida.setEnabled(false);
        jPanelNovoProduto.add(jTextFieldUnidadeMedida);
        jTextFieldUnidadeMedida.setBounds(400, 30, 70, 20);

        jLabel4.setText("Valor Unit.:");
        jPanelNovoProduto.add(jLabel4);
        jLabel4.setBounds(490, 10, 70, 20);

        jTextFieldValorUnitario.setEnabled(false);
        jPanelNovoProduto.add(jTextFieldValorUnitario);
        jTextFieldValorUnitario.setBounds(490, 30, 70, 20);

        jLabel5.setText("Qtde.:");
        jPanelNovoProduto.add(jLabel5);
        jLabel5.setBounds(580, 10, 40, 20);

        jTextFieldQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQuantidadeFocusLost(evt);
            }
        });
        jPanelNovoProduto.add(jTextFieldQuantidade);
        jTextFieldQuantidade.setBounds(580, 30, 40, 20);

        jPanelFormularioProdutos.add(jPanelNovoProduto);
        jPanelNovoProduto.setBounds(0, 0, 770, 70);

        jButtonRemoverItem.setText("Remover");
        jButtonRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverItemActionPerformed(evt);
            }
        });
        jPanelFormularioProdutos.add(jButtonRemoverItem);
        jButtonRemoverItem.setBounds(670, 130, 90, 30);

        jButtonAplicaDesconto.setText("Desconto");
        jButtonAplicaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAplicaDescontoActionPerformed(evt);
            }
        });
        jPanelFormularioProdutos.add(jButtonAplicaDesconto);
        jButtonAplicaDesconto.setBounds(670, 90, 90, 30);

        jPanelVenda.add(jPanelFormularioProdutos);
        jPanelFormularioProdutos.setBounds(10, 10, 770, 440);

        jTabbedPaneVenda.addTab("Venda", jPanelVenda);

        jPanelPagamento.setLayout(null);

        jPanelFormularioPagamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFormularioPagamento.setLayout(null);
        jPanelPagamento.add(jPanelFormularioPagamento);
        jPanelFormularioPagamento.setBounds(10, 10, 770, 440);

        jPanelAcoesPagamento.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelAcoesPagamentoLayout = new javax.swing.GroupLayout(jPanelAcoesPagamento);
        jPanelAcoesPagamento.setLayout(jPanelAcoesPagamentoLayout);
        jPanelAcoesPagamentoLayout.setHorizontalGroup(
            jPanelAcoesPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanelAcoesPagamentoLayout.setVerticalGroup(
            jPanelAcoesPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelPagamento.add(jPanelAcoesPagamento);
        jPanelAcoesPagamento.setBounds(10, 460, 770, 100);

        jTabbedPaneVenda.addTab("Pagamento", jPanelPagamento);

        jPanelEntrega.setLayout(null);

        jPanelFormularioEntrega.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFormularioEntrega.setLayout(null);
        jPanelEntrega.add(jPanelFormularioEntrega);
        jPanelFormularioEntrega.setBounds(10, 10, 770, 440);

        jPanelAcoesEntrega.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelAcoesEntregaLayout = new javax.swing.GroupLayout(jPanelAcoesEntrega);
        jPanelAcoesEntrega.setLayout(jPanelAcoesEntregaLayout);
        jPanelAcoesEntregaLayout.setHorizontalGroup(
            jPanelAcoesEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanelAcoesEntregaLayout.setVerticalGroup(
            jPanelAcoesEntregaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelEntrega.add(jPanelAcoesEntrega);
        jPanelAcoesEntrega.setBounds(10, 460, 770, 100);

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
    private javax.swing.JButton jButtonNovaVenda;
    private javax.swing.JButton jButtonRemoverItem;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelAcoesEntrega;
    private javax.swing.JPanel jPanelAcoesFormulario;
    private javax.swing.JPanel jPanelAcoesPagamento;
    private javax.swing.JPanel jPanelEntrega;
    private javax.swing.JPanel jPanelFormularioEntrega;
    private javax.swing.JPanel jPanelFormularioPagamento;
    private javax.swing.JPanel jPanelFormularioProdutos;
    private javax.swing.JPanel jPanelNovoProduto;
    private javax.swing.JPanel jPanelPagamento;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelVenda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneVenda;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldSubtotal;
    private javax.swing.JTextField jTextFieldUnidadeMedida;
    private javax.swing.JTextField jTextFieldValorUnitario;
    // End of variables declaration//GEN-END:variables

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
            return;
        }

        try {
            VendaProduto vendaProduto = new VendaProduto();
            vendaProduto.setProduto(produto);
            vendaProduto.setQuantidade(Double.parseDouble(jTextFieldQuantidade.getText()));
            vendaProduto.setValor(produto.getValor());
            vendaProduto.setVenda(new Venda());

            produtos.add(vendaProduto);
            produtoModel.setVendaProdutos(produtos);

            calculaSubtotal();
            limparProduto();
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }

    private void limparProduto() {
        produto = null;
        limparCamposDoContainer(jPanelNovoProduto);
        jTextFieldCodigoProduto.requestFocus();
    }

    private void calculaSubtotal() {
        Double subtotal = 0.0;
        for (VendaProduto produto : produtos) {
            if (produto.getDesconto() != null && produto.getDesconto() > 0.0) {
                Double porcentagemDesconto = (100.0 - produto.getDesconto()) / 100.0;
                Double valorComDesconto = porcentagemDesconto * (produto.getValor() * produto.getQuantidade());
                subtotal += valorComDesconto;
            } else {
                subtotal += produto.getQuantidade() * produto.getValor();
            }
        }
        jTextFieldSubtotal.setText(NumberFormat.getCurrencyInstance().format(subtotal));
    }

    private void novaVenda() {
        try {
            venda = new Venda();
            venda.setId(servico.consultarProximoId());
            venda.setTerminal(FrameUtil.terminalLogado);
        } catch (PDVException e) {
            addMensagemErro(e.getMessage());
        }
    }

    private void removerItem() {
        try {
            obterProdutoSelecionado();
            produtos.remove(vendaProduto);
            produtoModel.setVendaProdutos(produtos);

            calculaSubtotal();
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

    private void aplicarDesconto() {
        try {
            obterProdutoSelecionado();
            Double desconto = Double.parseDouble(
                    JOptionPane.showInputDialog("Informe a porcentagem do desconto a ser aplicado:"));
            
            vendaProduto.setDesconto(desconto);
            produtoModel.refresh();
            
            calculaSubtotal();
        } catch (NumberFormatException e) {
            addMensagemErro("Valor inválido!");
        } catch (Exception e) {
            addMensagemErro(e.getMessage());
        }
    }
}
