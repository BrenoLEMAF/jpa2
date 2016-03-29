package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaAlteraConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		em.getTransaction().begin();
		
		Conta conta = cDAO.busca(2);
		conta.setTitular("Ciclano da Silva");
		
		em.getTransaction().commit();
		em.close();	
	}

}
