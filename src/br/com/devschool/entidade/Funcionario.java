package br.com.devschool.entidade;

import br.com.devschool.util.template.Entidade;
import java.util.Date;
import java.util.Objects;

public class Funcionario extends Entidade {
    
    private Integer id;
    private String nome;
    private Date dataAdmissao;
    private boolean status;
    private String cpf;
    private String senha;
    private Cargo cargo;

    public Funcionario(Integer id, String nome, Date dataAdmissao, boolean status, String cpf, String senha, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.status = status;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Funcionario() {
        status = true;
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

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargo() {
        if (cargo == null) {
            cargo = new Cargo();
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
