package net.desafio.springboot2.dock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "conta", schema ="dock")
@ApiModel(description="Todos os detalhes da conta bancária ")
public class Conta {

	@ApiModelProperty(notes = "ID  com autoincrement")
	private long idConta;

	@ApiModelProperty(notes = "ID do usuario")
	private long idPessoa;

	@ApiModelProperty(notes = "Saldo da conta")
	private BigDecimal saldo;

	@ApiModelProperty(notes = "Limite da conta")
	private BigDecimal limiteSaqueDiario;

	@ApiModelProperty(notes = "Flag da conta ativa")
	private Long flagAtivo;

	@ApiModelProperty(notes = "Tipo da Conta")
	private Long tipoConta;

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@ApiModelProperty(notes = "Data de criação da conta")
	private Date dataCriacao;

	public Conta() { }

	public Conta(long idConta, long idPessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario,
				 Long flagAtivo, Long tipoConta, Date dataCriacao) {
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.idConta = idConta;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = dataCriacao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conta", nullable = false)
	public long getIdConta() {
		return idConta;
	}

	public void setIdConta(long id) {
		this.idConta = id;
	}

	@Column(name = "id_pessoa", nullable = false)
	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Column(name = "saldo", nullable = false)
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Column(name = "limite_saque_diario", nullable = false)
	public BigDecimal getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	@Column(name = "flag_ativo", nullable = false)
	public Long isFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(Long flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	@Column(name = "tipo_conta", nullable = false)
	public Long getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(Long tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}


	@Override
	public String toString() {
		return "Conta [id=" + idConta + ", idPessoa=" + idPessoa + ", saldo=" + saldo + ", limiteSaqueDiario="
				+ limiteSaqueDiario  + ", flagAtivo=" + flagAtivo + ", tipoConta=" + tipoConta +  ", dataCriacao="
				+ dataCriacao.toString() + "]";
	}

}
