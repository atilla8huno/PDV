package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Date;
import java.util.Objects;

public class MovimentoCaixa extends Entidade {

    private Integer id;
    private Date dataHoraAbertura;
    private Date dataHoraFechamento;
    private Double fundoAbertura;
    private Double fundoFechamento;
    private Terminal terminal;
    private Funcionario funcionario;

    public MovimentoCaixa(Integer id, Date dataHoraAbertura, Date dataHoraFechamento, Double fundoAbertura, Double fundoFechamento, Terminal terminal, Funcionario funcionario) {
        this.id = id;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.fundoAbertura = fundoAbertura;
        this.fundoFechamento = fundoFechamento;
        this.terminal = terminal;
        this.funcionario = funcionario;
    }

    public MovimentoCaixa() {
        this.fundoAbertura = 100.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public Double getFundoAbertura() {
        return fundoAbertura;
    }

    public void setFundoAbertura(Double fundoAbertura) {
        this.fundoAbertura = fundoAbertura;
    }

    public Double getFundoFechamento() {
        return fundoFechamento;
    }

    public void setFundoFechamento(Double fundoFechamento) {
        this.fundoFechamento = fundoFechamento;
    }

    public Terminal getTerminal() {
        if (terminal == null) {
            terminal = new Terminal();
        }
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final MovimentoCaixa other = (MovimentoCaixa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
