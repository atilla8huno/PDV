package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Objects;

public class Terminal extends Entidade {
    
    private Integer id;
    private Integer numero;
    private boolean status;

    public Terminal(Integer id, Integer numero, boolean status) {
        this.id = id;
        this.numero = numero;
        this.status = status;
    }

    public Terminal() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Terminal other = (Terminal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
