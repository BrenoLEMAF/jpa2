package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaCalculaTotalMovimentado {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		Conta conta = cDAO.busca(2);
		BigDecimal soma = mDAO.calculaTotalMovimentado(conta, TipoMovimentacao.SAIDA);
		em.getTransaction().commit();
		em.close();
		System.out.println(soma.toPlainString());
	}

}
