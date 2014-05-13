package br.com.devschool.util.template;

public abstract class Entidade {
    
    public abstract Integer getId();
    
    public boolean isTransient() {
        return getId() == null || getId() <= 0;
    }
}
