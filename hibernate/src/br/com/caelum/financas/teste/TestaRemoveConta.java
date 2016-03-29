package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaRemoveConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		em.getTransaction().begin();
		
		Conta encontrado = cDAO.busca(3);
		cDAO.remove(encontrado);
		encontrado = cDAO.busca(4);
		cDAO.remove(encontrado);
		encontrado = cDAO.busca(5);
		cDAO.remove(encontrado);
		encontrado = cDAO.busca(6);
		cDAO.remove(encontrado);
		
		em.getTransaction().commit();
		em.close();	

	}

}
