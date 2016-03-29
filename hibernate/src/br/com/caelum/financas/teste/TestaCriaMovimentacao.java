package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaCriaMovimentacao {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em); 
		ContaDAO cDAO = new ContaDAO(em);
		
		Movimentacao movimentacao = new Movimentacao();
		
		em.getTransaction().begin();
		Conta conta = cDAO.busca(2);
		em.getTransaction().commit();
		
		movimentacao.setDescricao("Saque");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setValor(new BigDecimal("100.00"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		
		mDAO.adiciona(movimentacao);		
		
		em.getTransaction().commit();
		em.close();
	}

}
