package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Objects;

public class Produto extends Entidade {

    private Integer id;
    private String nome;
    private Integer codigo;
    private Double valor;
    private boolean status;
    private UnidadeMedida unidadeMedida;

    public Produto(Integer id, String nome, Integer codigo, Double valor, boolean status, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.status = status;
        this.unidadeMedida = unidadeMedida;
    }

    public Produto() {
        status = Boolean.TRUE;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UnidadeMedida getUnidadeMedida() {
        if (unidadeMedida == null) {
            unidadeMedida = new UnidadeMedida();
        }
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}
