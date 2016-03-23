package br.com.caelum.financas.teste;

import java.awt.SystemColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Breno Rios Zeymer");
		conta.setBanco("Santander");
		conta.setNumero("123456-9");
		conta.setAgencia("9876");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Conta gravada com sucesso!");
		System.out.println("Executado em: " + (fim - inicio) + " millissegundos");
	}
}
