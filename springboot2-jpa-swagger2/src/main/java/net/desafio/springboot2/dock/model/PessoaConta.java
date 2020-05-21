package net.desafio.springboot2.dock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "pessoa_conta", schema ="dock")
@ApiModel(description="Tabela de Relacionamento entre pessoa e conta ")
public class PessoaConta {

    @ApiModelProperty(notes = "ID  com autoincrement")
    private long idPessoaConta;

    @ApiModelProperty(notes = "ID do usuario")
    private long idConta;

    @ApiModelProperty(notes = "ID do usuario")
    private long idPessoa;

    public PessoaConta(){}

    public PessoaConta(long idPessoaConta, long idConta, long idPessoa) {
        this.idPessoaConta = idPessoaConta;
        this.idConta = idConta;
        this.idPessoa = idPessoa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa_conta", nullable = false)
    public long getIdPessoaConta() {
        return idPessoaConta;
    }

    public void setIdPessoaConta(long idPessoaConta) {
        this.idPessoaConta = idPessoaConta;
    }

    @Column(name = "id_conta", nullable = false)
    public long getIdConta() {
        return idConta;
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    @Column(name = "id_pessoa", nullable = false)
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }
}
