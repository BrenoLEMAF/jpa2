package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em); 
		
		Conta conta = new Conta("Maria Tereza Rios", "3245", "654987-5", "Banco do Brasil");
		Conta conta2 = new Conta("Raphael Rios Zeymer", "5487", "753698-9", "Itaú");
		Conta conta3 = new Conta("Breno Rios Zeymer", "8754", "588752-5", "Santander");
		Conta conta4 = new Conta("Fulano de Tal", "9631", "891264-9", "Itaú");
		
		em.getTransaction().begin();
		cDAO.adiciona(conta);
		cDAO.adiciona(conta2);
		cDAO.adiciona(conta3);
		cDAO.adiciona(conta4);
		em.getTransaction().commit();
		em.close();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Conta gravada com sucesso!");
		System.out.println("Executado em: " + (fim - inicio) + " millissegundos");
	}
}
