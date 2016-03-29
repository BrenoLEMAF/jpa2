package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaListaValorETipo {
	public static void main(String[] args){
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em);
		em.getTransaction().begin();
		
		List<Movimentacao> lista = mDAO.listaPorValorETipo(new BigDecimal("90"), TipoMovimentacao.SAIDA);
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao.getDescricao() + " = "  
					+ movimentacao.getValor().toPlainString());
		}
		
		em.getTransaction().commit();
		em.close();	
	}
}
