package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMes;

public class TesteListaMesesComMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = cDAO.busca(2);
		
		List<ValorPorMes> listaEntrada = mDAO.listaMesesComMovimentacoes(conta, TipoMovimentacao.ENTRADA);
		List<ValorPorMes> listaSaida = mDAO.listaMesesComMovimentacoes(conta, TipoMovimentacao.SAIDA);
		
		System.out.println("Entrada de valores:");
		for (ValorPorMes valorPorMes : listaEntrada) {
			System.out.println(valorPorMes.getMes() + " = " + valorPorMes.getValor());
		}
		System.out.println("Saída de valores:");
		for (ValorPorMes valorPorMes : listaSaida) {
			System.out.println(valorPorMes.getMes() + " = " + valorPorMes.getValor());
		}
		
		em.getTransaction().commit();
		em.close();

	}

}
