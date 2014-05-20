package br.com.devschool.forma_pagamento.visao;

import br.com.devschool.entidade.FormaPagamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

public class FormaPagamentoTableModel extends AbstractTableModel {

    private final int COLUNA_DESCRICAO    = 0;
    
    private List<FormaPagamento> formaPagamentos;

    public FormaPagamentoTableModel() {
        super();
    }

    public FormaPagamentoTableModel(List<FormaPagamento> formaPagamentos) {
        this();
        this.formaPagamentos = new ArrayList<FormaPagamento>(formaPagamentos);
        fireTableDataChanged();
    }
    
    public FormaPagamento getFormaPagamento(int pos){
        if(pos < 0 || pos >= formaPagamentos.size()){
            return null;
        } else {
            return formaPagamentos.get(pos);
        }
    }
    
    public void limparLista(){
        getFormaPagamentos().clear();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return formaPagamentos.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return formaPagamentos.get(rowIndex).getDescricao();
    }

    @Override
    public String getColumnName(int column) {
        return "Descrição da Forma de Pagamento";
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
        FormaPagamento c = formaPagamentos.get(rowIndex);
        c.setDescricao(aValue.toString());
        
        fireTableDataChanged();
    }

    /* // EXEMPLO DE PESQUISA
    public List<FormaPagamento> pesquisarPalavraChave(String palavraChave){
        formaPagamentos.clear();
        formaPagamentos = servico.getFormaPagamentosPorPalavraChave(palavraChave);
        fireTableDataChanged();
        return formaPagamentos;
    }
    */
    
    public List<FormaPagamento> getFormaPagamentos() {
        if (formaPagamentos == null) {
            formaPagamentos = new ArrayList<FormaPagamento>();
        }
        return formaPagamentos;
    }
   
    /**
     * @param List<FormaPagamento>
     */
    public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = new ArrayList<FormaPagamento>(formaPagamentos);
        fireTableDataChanged();
    }
    
    /**
     * @param Set<FormaPagamento>
     */
    public void setFormaPagamentos(Set<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = new ArrayList<FormaPagamento>(formaPagamentos);
        fireTableDataChanged();
    }
}
