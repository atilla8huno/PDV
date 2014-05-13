package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Objects;

public class FormaPagamento extends Entidade {
    
    private Integer id;
    private String descricao;

    public FormaPagamento(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public FormaPagamento() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final FormaPagamento other = (FormaPagamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
