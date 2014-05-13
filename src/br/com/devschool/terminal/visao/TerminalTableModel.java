package br.com.devschool.terminal.visao;

import br.com.devschool.entidade.Terminal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class TerminalTableModel extends AbstractTableModel {

    private final int COLUNA_NUMERO    = 0;
    private final int COLUNA_STATUS  = 1;
    
    private List<Terminal> terminals;

    public TerminalTableModel() {
        super();
    }

    public TerminalTableModel(List<Terminal> terminals) {
        this();
        this.terminals = new ArrayList<Terminal>(terminals);
        fireTableDataChanged();
    }
    
    public Terminal getTerminal(int pos){
        if(pos < 0 || pos >= terminals.size()){
            return null;
        } else {
            return terminals.get(pos);
        }
    }
    
    public void limparLista(){
        getTerminals().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return terminals.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Terminal c = terminals.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NUMERO:
                return c.getNumero();
            case COLUNA_STATUS:
                return c.isStatus();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_NUMERO:
                return "Número do Terminal";
            case COLUNA_STATUS:
                return "Status do Terminal";
            default:
                return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case COLUNA_NUMERO:
                return Integer.class;
            case COLUNA_STATUS:
                return Boolean.class;
            default:
                return Integer.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Terminal c = terminals.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NUMERO:
                c.setNumero((Integer) aValue);
            case COLUNA_STATUS:
                c.setStatus((Boolean) aValue);
        }
        
        fireTableDataChanged();
    }
    
    public List<Terminal> getTerminals() {
        if (terminals == null) {
            terminals = new ArrayList<Terminal>();
        }
        return terminals;
    }
   
    /**
     * @param List<Terminal>
     */
    public void setTerminals(List<Terminal> terminals) {
        this.terminals = new ArrayList<Terminal>(terminals);
        fireTableDataChanged();
    }
    
    /**
     * @param Set<Terminal>
     */
    public void setTerminals(Set<Terminal> terminals) {
        this.terminals = new ArrayList<Terminal>(terminals);
        fireTableDataChanged();
    }
}
