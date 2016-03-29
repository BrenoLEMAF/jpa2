package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscaListaMovimentacoes {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = cDAO.busca(2);
		
		List<Movimentacao> movimentacoes = mDAO.listaTodasMovimentacoes(conta);
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getDescricao() + " = "  
					+ movimentacao.getValor().toPlainString());
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
}
