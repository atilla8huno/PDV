package br.com.devschool.entidade;

import java.util.Objects;

public class VendaFormaPagamento {

    private Integer id;
    private Double valor;
    private FormaPagamento formaPagamento;
    private Venda venda;

    public VendaFormaPagamento(Integer id, Double valor, FormaPagamento formaPagamento, Venda venda) {
        this.id = id;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.venda = venda;
    }

    public VendaFormaPagamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public FormaPagamento getFormaPagamento() {
        if (formaPagamento == null) {
            formaPagamento = new FormaPagamento();
        }
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Venda getVenda() {
        if (venda == null) {
            venda = new Venda();
        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VendaFormaPagamento other = (VendaFormaPagamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
