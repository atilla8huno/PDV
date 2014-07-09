package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Objects;

public class VendaProduto extends Entidade {
    
    private Integer id;
    private Double quantidade;
    private Double valor;
    private Double desconto;
    private Venda venda;
    private Produto produto;

    public VendaProduto(Integer id, Double quantidade, Double valor, Double desconto, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
        this.venda = venda;
        this.produto = produto;
    }

    public VendaProduto() {
        desconto = 0.0;
    }

    public Double calculaSubtotal() {
        Double subtotal = 0.0;
        if (getDesconto() != null && getDesconto() > 0.0) {
            Double porcentagemDesconto = (100.0 - getDesconto()) / 100.0;
            Double valorComDesconto = porcentagemDesconto * (getValor() * getQuantidade());
            subtotal += valorComDesconto;
        } else {
            subtotal += getQuantidade() * produto.getValor();
        }
        return subtotal;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public Produto getProduto() {
        if (produto == null) {
            produto = new Produto();
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final VendaProduto other = (VendaProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
