package br.com.devschool.util.enumerador;

import java.util.Arrays;
import java.util.List;

public enum PerfilEnum {

    DESENVOLVEDOR, ATENDENTE, SUPERVISOR, ADMINISTRADOR;
    
    private PerfilEnum() {
    }

    public static List<PerfilEnum> listar() {
        return Arrays.asList(values());
    }
}
