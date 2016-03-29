package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaPesquisaIdConta {
	public static void main(String[] args){
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		em.getTransaction().begin();
		Conta encontrado1 = cDAO.busca(3);
		Conta encontrado2 = cDAO.busca(4);
		Conta encontrado3 = cDAO.busca(5);
		Conta encontrado4 = cDAO.busca(6);
		em.getTransaction().commit();
		em.close();	
	}
}
