package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaListagemConta {
	public static void main(String[] args){
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		em.getTransaction().begin();
		
		List<Conta> lista = cDAO.lista();
		for (Conta conta : lista) {
			for (Movimentacao mov : conta.getMovimentacoes()) {
				System.out.println(mov.getDescricao());	
			}
		}
		
		em.getTransaction().commit();
		em.close();	
	}
}
