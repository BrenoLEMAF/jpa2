package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	public Tag(String nome) {
		this.nome = nome;
	}
	public Tag() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
}
