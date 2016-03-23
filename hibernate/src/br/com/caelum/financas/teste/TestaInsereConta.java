package br.com.caelum.financas.teste;

import java.awt.SystemColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Raphael Rios Zeymer");
		conta.setBanco("Itaú");
		conta.setNumero("709388-9");
		conta.setAgencia("8347");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Conta gravada com sucesso!");
		System.out.println("Executado em: " + (fim - inicio) + " millissegundos");
	}
}
