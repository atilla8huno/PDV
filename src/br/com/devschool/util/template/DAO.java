package br.com.devschool.util.template;

import br.com.devschool.util.PDVException;
import java.util.List;

public abstract class DAO<T extends Entidade> {
    
    protected abstract T salvar(T entidade) throws PDVException;
    protected abstract T atualizar(T entidade) throws PDVException;
    protected abstract void excluir(Integer id) throws PDVException;
    protected abstract List<T> consultar() throws PDVException;
    protected abstract List<T> consultar(int maxResult) throws PDVException;
    protected abstract T consultarPorId(int id) throws PDVException;
}
