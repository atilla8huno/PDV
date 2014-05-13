package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Date;
import java.util.Objects;

public class Venda extends Entidade {
    
    private Integer id;
    private Date dataCadastro;
    private boolean entregaDomicilio;
    private String nomeCliente;
    private String enderecoCliente;
    private String contatoCliente;
    private Double valorTotal;
    private Double valorPago;
    private Double valorTroco;
    private Terminal terminal;

    public Venda(Integer id, Date dataCadastro, boolean entregaDomicilio, String nomeCliente, String enderecoCliente, String contatoCliente, Double valorTotal, Double valorPago, Double valorTroco, Terminal terminal) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.entregaDomicilio = entregaDomicilio;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.contatoCliente = contatoCliente;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.valorTroco = valorTroco;
        this.terminal = terminal;
    }

    public Venda() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isEntregaDomicilio() {
        return entregaDomicilio;
    }

    public void setEntregaDomicilio(boolean entregaDomicilio) {
        this.entregaDomicilio = entregaDomicilio;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(Double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
