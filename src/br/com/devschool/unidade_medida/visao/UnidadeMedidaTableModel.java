package br.com.devschool.unidade_medida.visao;

import br.com.devschool.entidade.UnidadeMedida;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class UnidadeMedidaTableModel extends AbstractTableModel {

    private final int COLUNA_DESCRICAO    = 0;
    private final int COLUNA_SIGLA  = 1;
    
    private List<UnidadeMedida> unidadeMedidas;

    public UnidadeMedidaTableModel() {
        super();
    }

    public UnidadeMedidaTableModel(List<UnidadeMedida> unidadeMedidas) {
        this();
        this.unidadeMedidas = new ArrayList<UnidadeMedida>(unidadeMedidas);
        fireTableDataChanged();
    }
    
    public UnidadeMedida getUnidadeMedida(int pos){
        if(pos < 0 || pos >= unidadeMedidas.size()){
            return null;
        } else {
            return unidadeMedidas.get(pos);
        }
    }
    
    public void limparLista(){
        getUnidadeMedidas().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return unidadeMedidas.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UnidadeMedida c = unidadeMedidas.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_DESCRICAO:
                return c.getDescricao();
            case COLUNA_SIGLA:
                return c.getSigla().toUpperCase();
            default:
                return c;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case COLUNA_DESCRICAO:
                return "Descrição da Unidade de Medida";
            case COLUNA_SIGLA:
                return "Sigla da Unidade de Medida";
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
        UnidadeMedida c = unidadeMedidas.get(rowIndex);
        
        switch(columnIndex) {
            case COLUNA_DESCRICAO:
                c.setDescricao(aValue.toString());
            case COLUNA_SIGLA:
                c.setSigla(aValue.toString().toUpperCase());
        }
        
        fireTableDataChanged();
    }

    /* // EXEMPLO DE PESQUISA
    public List<UnidadeMedida> pesquisarPalavraChave(String palavraChave){
        unidadeMedidas.clear();
        unidadeMedidas = servico.getUnidadeMedidasPorPalavraChave(palavraChave);
        fireTableDataChanged();
        return unidadeMedidas;
    }
    */
    
    public List<UnidadeMedida> getUnidadeMedidas() {
        if (unidadeMedidas == null) {
            unidadeMedidas = new ArrayList<UnidadeMedida>();
        }
        return unidadeMedidas;
    }
   
    /**
     * @param List<UnidadeMedida>
     */
    public void setUnidadeMedidas(List<UnidadeMedida> unidadeMedidas) {
        this.unidadeMedidas = new ArrayList<UnidadeMedida>(unidadeMedidas);
        fireTableDataChanged();
    }
    
    /**
     * @param Set<UnidadeMedida>
     */
    public void setUnidadeMedidas(Set<UnidadeMedida> unidadeMedidas) {
        this.unidadeMedidas = new ArrayList<UnidadeMedida>(unidadeMedidas);
        fireTableDataChanged();
    }
}
