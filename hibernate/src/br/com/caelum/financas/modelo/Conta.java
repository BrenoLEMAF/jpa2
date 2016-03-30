package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"gerente_id", "teste"}))
public class Conta {
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;

	@OneToOne
	@JoinColumn(unique=true)
	private Gerente gerente;

	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique=true)
	public int teste;
	
	public Conta(){
		
	}
	
	public Conta(String titular, String agencia, String numero, String banco) {
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.banco = banco;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	
	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public Integer getId() {
		return id;
	}
	
	
}
