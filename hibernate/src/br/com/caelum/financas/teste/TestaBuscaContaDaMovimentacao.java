package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.getReference(Movimentacao.class, 1);
		
		System.out.println(movimentacao.getConta().getTitular());
		
		em.getTransaction().commit();
		em.close();
	}
}
