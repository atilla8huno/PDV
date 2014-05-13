package br.com.devschool.util.template;

import java.awt.Container;

public interface IFrame<T> {

    public boolean isValidarCamposObrigatorios();
    public void marcarCamposObrigatorios();
    public void preencherEntidade();
    public void preencherFormulario(T t);
    public void obterLinhaSelecionada();
    public void limparFormulario(Container formulario);
    public void limparConsulta();
    
    public void salvar();
    public void excluir();
    public void editar();
    public void pesquisar();
}
