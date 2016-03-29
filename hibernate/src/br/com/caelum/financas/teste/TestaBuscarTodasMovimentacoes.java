package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscarTodasMovimentacoes {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		
		List<Movimentacao> movimentacoes = mDAO.buscaTodasMovimentacoesDaConta("da");
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getId() + " = "  
					+ movimentacao.getDescricao() + " = "  
					+ movimentacao.getValor().toPlainString());
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
}
