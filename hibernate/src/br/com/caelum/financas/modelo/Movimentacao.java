package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Movimentacao {

	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private Calendar data;
	private BigDecimal valor;

	@ManyToOne
	private Conta conta;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	@ManyToMany
	private List<Tag> tags = new ArrayList<Tag>();

	public Movimentacao() {
	}

	public Movimentacao(String descricao, Calendar data, BigDecimal valor, Conta conta,
			TipoMovimentacao tipoMovimentacao) {
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.conta = conta;
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

}
