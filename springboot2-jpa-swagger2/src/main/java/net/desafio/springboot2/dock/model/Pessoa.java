package net.desafio.springboot2.dock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "pessoa", schema ="dock")
@ApiModel(description="Todos os detalhes do cliente da conta ")
public class Pessoa {

    @ApiModelProperty(notes = "ID do usuario")
    private long idPessoa;

    @ApiModelProperty(notes = "Nome da pessoa")
    private String nome;

    @ApiModelProperty(notes = "Cpf da pessoa")
    private String cpf;

    @ApiModelProperty(notes = "Data de Nascimento da pessoa")
    private Date dataNascimento;

    public Pessoa() { }

    public Pessoa(long idPessoa, String nome, String cpf, Date dataNascimento) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa", nullable = false)
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "data_nascimento", nullable = false)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
                + dataNascimento  + "]";
    }

}
