package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta("Maria Joaquina", "8754", "132354-5", "Bradesco");
		
		Movimentacao movimentacao = new Movimentacao("Conta da Internet", Calendar.getInstance(), 
				new BigDecimal("90.00"), conta, TipoMovimentacao.SAIDA);
		
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();

	}

}
