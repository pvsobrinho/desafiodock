package net.desafio.springboot2.dock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transacao", schema ="dock")
@ApiModel(description="Todos os detalhes da transacao bancária ")
public class Transacao {

    @ApiModelProperty(notes = "ID da transacao")
    private long idTransacao;

    @ApiModelProperty(notes = "ID do conta")
    private long idConta;

    @ApiModelProperty(notes = "Descricao da operacao")
    private String descricao;

    @ApiModelProperty(notes = "Valor da transacao")
    private BigDecimal valor;

    @ApiModelProperty(notes = "Data da transacao")
    private Date dataTransacao;

    public Transacao(){}

    public Transacao(long idTransacao, long idConta, BigDecimal valor, Date dataTransacao, String descricao) {
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transacao", nullable = false)
    public long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(long idTransacao) {
        this.idTransacao = idTransacao;
    }

    @Column(name = "id_conta", nullable = false)
    public long getIdConta() {
        return idConta;
    }

    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }

    @Column(name = "valor", nullable = false)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Column(name = "data_transacao", nullable = false)
    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Column(name = "descricao", nullable = false)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
