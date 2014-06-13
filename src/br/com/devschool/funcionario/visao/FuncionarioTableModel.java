package br.com.devschool.funcionario.visao;

import br.com.devschool.entidade.Funcionario;
import br.com.devschool.util.DateUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel {

    private final int COLUNA_NOME   = 0;
    private final int COLUNA_DATA_ADMISSAO = 1;
    private final int COLUNA_CPF    = 2;
    private final int COLUNA_CARGO  = 3;
    
    private List<Funcionario> funcionarios;

    public FuncionarioTableModel() {
        super();
    }

    public FuncionarioTableModel(List<Funcionario> funcionarios) {
        this();
        this.funcionarios = new ArrayList(funcionarios);
        fireTableDataChanged();
    }
    
    public Funcionario getFuncionario(int pos){
        if(pos < 0 || pos >= funcionarios.size()){
            return null;
        } else {
            return funcionarios.get(pos);
        }
    }
    
    public void limparLista(){
        getFuncionarios().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario c = funcionarios.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NOME:
                return c.getNome().toUpperCase();
            case COLUNA_DATA_ADMISSAO:
                return DateUtil.date2String(c.getDataAdmissao());
            case COLUNA_CPF:
                return c.getCpf();
            case COLUNA_CARGO:
                return c.getCargo().getNome().toUpperCase();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_NOME:
                return "Nome do Funcionário";
            case COLUNA_DATA_ADMISSAO:
                return "Data de Admissão";
            case COLUNA_CPF:
                return "CPF";
            case COLUNA_CARGO:
                return "Cargo";
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
    
    public List<Funcionario> getFuncionarios() {
        if (funcionarios == null) {
            funcionarios = new ArrayList();
        }
        return funcionarios;
    }
   
    /**
     * @param List<Funcionario>
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = new ArrayList(funcionarios);
        fireTableDataChanged();
    }
    
    /**
     * @param Set<Funcionario>
     */
    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = new ArrayList(funcionarios);
        fireTableDataChanged();
    }
}
