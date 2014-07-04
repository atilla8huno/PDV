package br.com.devschool.produto.visao;

import br.com.devschool.entidade.Produto;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {

    private final int COLUNA_NOME    = 0;
    private final int COLUNA_CODIGO  = 1;
    private final int COLUNA_VALOR   = 2;
    private final int COLUNA_UNIDADE_MEDIDA = 3;
    
    private List<Produto> produtos;

    public ProdutoTableModel() {
        super();
    }

    public ProdutoTableModel(List<Produto> produtos) {
        this();
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }
    
    public Produto getProduto(int pos){
        if(pos < 0 || pos >= produtos.size()){
            return null;
        } else {
            return produtos.get(pos);
        }
    }
    
    public void limparLista(){
        getProdutos().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto c = produtos.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NOME:
                return c.getNome().toUpperCase();
            case COLUNA_CODIGO:
                return c.getCodigo();
            case COLUNA_VALOR:
                return NumberFormat.getCurrencyInstance().format(c.getValor());
            case COLUNA_UNIDADE_MEDIDA:
                return c.getUnidadeMedida().getSigla().toUpperCase();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_NOME:
                return "Nome do Produto";
            case COLUNA_CODIGO:
                return "Código";
            case COLUNA_VALOR:
                return "Valor";
            case COLUNA_UNIDADE_MEDIDA:
                return "Unidade de Medida";
            default:
                return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case COLUNA_CODIGO:
                return Integer.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        fireTableDataChanged();
    }
    
    public List<Produto> getProdutos() {
        if (produtos == null) {
            produtos = new ArrayList();
        }
        return produtos;
    }
   
    public void setProdutos(List<Produto> produtos) {
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }
    
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = new ArrayList(produtos);
        fireTableDataChanged();
    }
}
