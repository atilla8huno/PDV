package br.com.devschool.util.enumerador;

import java.util.Arrays;
import java.util.List;

public enum PerfilEnum {

    DESENVOLVEDOR("desenvolvedor"), ATENDENTE("atendente"), 
    SUPERVISOR("supervisor"), ADMINISTRADOR("administrador");
    
    private String nome;
    
    private PerfilEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public static List<PerfilEnum> valuesAsList() {
        return Arrays.asList(values());
    }
}
