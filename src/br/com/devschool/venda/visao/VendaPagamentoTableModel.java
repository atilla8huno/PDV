package br.com.devschool.venda.visao;

import br.com.devschool.entidade.VendaFormaPagamento;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class VendaPagamentoTableModel extends AbstractTableModel {

    private final int COLUNA_FORMA_PAGAMENTO = 0;
    private final int COLUNA_VALOR           = 1;
    
    private List<VendaFormaPagamento> pagamentos;

    public VendaPagamentoTableModel() {
        super();
    }

    public VendaPagamentoTableModel(List<VendaFormaPagamento> pagamentos) {
        this();
        this.pagamentos = new ArrayList(pagamentos);
        fireTableDataChanged();
    }
    
    public VendaFormaPagamento getVendaFormaPagamento(int pos){
        if(pos < 0 || pos >= pagamentos.size()){
            return null;
        } else {
            return pagamentos.get(pos);
        }
    }
    
    public void limparLista(){
        getVendaFormaPagamentos().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return pagamentos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaFormaPagamento c = pagamentos.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_FORMA_PAGAMENTO:
                return c.getFormaPagamento().getDescricao();
            case COLUNA_VALOR:
                return NumberFormat.getCurrencyInstance().format(c.getValor());
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_FORMA_PAGAMENTO:
                return "Forma de Pagamento";
            case COLUNA_VALOR:
                return "Valor Pago";
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
    
    public List<VendaFormaPagamento> getVendaFormaPagamentos() {
        if (pagamentos == null) {
            pagamentos = new ArrayList();
        }
        return pagamentos;
    }
   
    public void setVendaFormaPagamentos(List<VendaFormaPagamento> pagamentos) {
        this.pagamentos = new ArrayList(pagamentos);
        fireTableDataChanged();
    }
    
    public void setVendaFormaPagamentos(Set<VendaFormaPagamento> pagamentos) {
        this.pagamentos = new ArrayList(pagamentos);
        fireTableDataChanged();
    }
}
