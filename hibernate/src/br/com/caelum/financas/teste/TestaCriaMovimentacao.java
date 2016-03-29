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
		
		
		
		em.getTransaction().begin();
		Conta conta = cDAO.busca(2);
		Calendar c = Calendar.getInstance();
		
		cDAO.adiciona(conta);
		for (int i = 9; i < 12; i++) {
			c.set(Calendar.MONTH, i);
			Movimentacao movimentacao = new Movimentacao();
			Number valor = (i+1)*10;
			movimentacao.setDescricao("Conta de agua " + i);
			movimentacao.setData(c);
			movimentacao.setValor(new BigDecimal(valor.toString()));
			movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
			movimentacao.setConta(conta);
			mDAO.adiciona(movimentacao);
		}
		for (int i = 3; i < 12; i++) {
			c.set(Calendar.MONTH, i);
			Movimentacao movimentacao = new Movimentacao();
			Number valor = (i+1)*10;
			movimentacao.setDescricao("Conta de agua " + i);
			movimentacao.setData(c);
			movimentacao.setValor(new BigDecimal(valor.toString()));
			movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
			movimentacao.setConta(conta);
			mDAO.adiciona(movimentacao);
		}
		
		
		em.getTransaction().commit();
		em.close();
	}

}
