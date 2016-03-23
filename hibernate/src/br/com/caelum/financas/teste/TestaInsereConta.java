package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Raphael Rios Zeymer");
		conta.setBanco("Itaú");
		conta.setNumero("456789-2");
		conta.setAgencia("3216");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		System.out.println("Conta gravada com sucesso!");
	}
}
