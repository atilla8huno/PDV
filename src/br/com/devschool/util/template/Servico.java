package br.com.devschool.util.template;

import br.com.devschool.util.PDVException;
import java.sql.Connection;
import java.util.List;

public abstract class Servico<T extends Entidade> {
    
    public abstract T salvar(T entidade) throws PDVException;
    public abstract T salvar(T entidade, Connection conn) throws PDVException;
    public abstract T atualizar(T entidade) throws PDVException;
    public abstract T atualizar(T entidade, Connection conn) throws PDVException;
    public abstract void excluir(T entidade) throws PDVException;
    public abstract void excluir(T entidade, Connection conn) throws PDVException;
    public abstract void excluir(Integer id) throws PDVException;
    public abstract void excluir(Integer id, Connection conn) throws PDVException;
    public abstract List<T> consultar() throws PDVException;
    public abstract List<T> consultar(int maxResult) throws PDVException;
    public abstract T consultarPor(int id) throws PDVException;
}
