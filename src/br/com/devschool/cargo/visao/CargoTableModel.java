package br.com.devschool.cargo.visao;

import br.com.devschool.entidade.Cargo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class CargoTableModel extends AbstractTableModel {

    private final int COLUNA_NOME    = 0;
    private final int COLUNA_PERFIL  = 1;
    
    private List<Cargo> cargos;

    public CargoTableModel() {
        super();
    }

    public CargoTableModel(List<Cargo> cargos) {
        this();
        this.cargos = new ArrayList<Cargo>(cargos);
        fireTableDataChanged();
    }
    
    public Cargo getCargo(int pos){
        if(pos < 0 || pos >= cargos.size()){
            return null;
        } else {
            return cargos.get(pos);
        }
    }
    
    public void limparLista(){
        getCargos().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return cargos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cargo c = cargos.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NOME:
                return c.getNome().toUpperCase();
            case COLUNA_PERFIL:
                return c.getPerfil().toLowerCase();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_NOME:
                return "Nome do Cargo";
            case COLUNA_PERFIL:
                return "Perfil do Cargo";
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
        Cargo c = cargos.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_NOME:
                c.setNome(aValue.toString().toUpperCase());
            case COLUNA_PERFIL:
                c.setPerfil(aValue.toString().toLowerCase());
        }
        
        fireTableDataChanged();
    }

    /* // EXEMPLO DE PESQUISA
    public List<Cargo> pesquisarPalavraChave(String palavraChave){
        cargos.clear();
        cargos = servico.getCargosPorPalavraChave(palavraChave);
        fireTableDataChanged();
        return cargos;
    }
    */
    
    public List<Cargo> getCargos() {
        if (cargos == null) {
            cargos = new ArrayList<Cargo>();
        }
        return cargos;
    }
   
    /**
     * @param List<Cargo>
     */
    public void setCargos(List<Cargo> cargos) {
        this.cargos = new ArrayList<Cargo>(cargos);
        fireTableDataChanged();
    }
    
    /**
     * @param Set<Cargo>
     */
    public void setCargos(Set<Cargo> cargos) {
        this.cargos = new ArrayList<Cargo>(cargos);
        fireTableDataChanged();
    }
}
