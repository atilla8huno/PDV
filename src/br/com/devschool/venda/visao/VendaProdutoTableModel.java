package br.com.devschool.venda.visao;

import br.com.devschool.entidade.VendaProduto;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class VendaProdutoTableModel extends AbstractTableModel {

    private final int COLUNA_ITEM           = 0;
    private final int COLUNA_CODIGO         = 1;
    private final int COLUNA_NOME_PRODUTO   = 2;
    private final int COLUNA_VALOR_UNITARIO = 3;
    private final int COLUNA_UNIDADE_MEDIDA = 4;
    private final int COLUNA_QUANTIDADE     = 5;
    private final int COLUNA_DESCONTO       = 6;
    private final int COLUNA_SUBTOTAL       = 7;

    private List<VendaProduto> produtos;

    public VendaProdutoTableModel() {
        super();
    }

    public VendaProdutoTableModel(List<VendaProduto> produtos) {
        this();
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }

    public VendaProduto getVendaProduto(int pos) {
        if (pos < 0 || pos >= produtos.size()) {
            return null;
        } else {
            return produtos.get(pos);
        }
    }

    public void limparLista() {
        getVendaProdutos().clear();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaProduto c = produtos.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_ITEM:
                return rowIndex++;
            case COLUNA_CODIGO:
                return c.getProduto().getCodigo().toString();
            case COLUNA_NOME_PRODUTO:
                return c.getProduto().getNome();
            case COLUNA_VALOR_UNITARIO:
                return NumberFormat.getCurrencyInstance().format(c.getValor());
            case COLUNA_UNIDADE_MEDIDA:
                return c.getProduto().getUnidadeMedida().getDescricao();
            case COLUNA_QUANTIDADE:
                return c.getQuantidade().toString();
            case COLUNA_DESCONTO:
                return "0.0";
            case COLUNA_SUBTOTAL:
                return c.getQuantidade() * c.getValor();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COLUNA_ITEM:
                return "Item";
            case COLUNA_CODIGO:
                return "Código";
            case COLUNA_NOME_PRODUTO:
                return "Produto";
            case COLUNA_VALOR_UNITARIO:
                return "Valor Unit.";
            case COLUNA_UNIDADE_MEDIDA:
                return "Un. de Medida";
            case COLUNA_QUANTIDADE:
                return "Qtde.";
            case COLUNA_DESCONTO:
                return "Desconto";
            case COLUNA_SUBTOTAL:
                return "Subtotal";
            default:
                return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        fireTableDataChanged();
    }

    public List<VendaProduto> getVendaProdutos() {
        if (produtos == null) {
            produtos = new ArrayList();
        }
        return produtos;
    }

    public void setVendaProdutos(List<VendaProduto> produtos) {
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }

    public void setVendaProdutos(Set<VendaProduto> produtos) {
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }
}
