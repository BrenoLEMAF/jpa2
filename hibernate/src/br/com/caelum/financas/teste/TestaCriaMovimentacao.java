package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaCriaMovimentacao {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO mDAO = new MovimentacaoDAO(em); 
		ContaDAO cDAO = new ContaDAO(em);
		TagDAO tDAO = new TagDAO(em);

		em.getTransaction().begin();
		Conta conta = cDAO.busca(2);
		Calendar c = Calendar.getInstance();

		cDAO.adiciona(conta);
		
		Tag t1 = tDAO.adicionaOuBuscaTagComNome("Tag 1");
		Tag t2 = tDAO.adicionaOuBuscaTagComNome("Tag 17");
		Tag t3 = tDAO.adicionaOuBuscaTagComNome("Tag 2");
		Tag t4 = tDAO.adicionaOuBuscaTagComNome("Tag 29");
		Tag t5 = tDAO.adicionaOuBuscaTagComNome("Tag 3");
		
		List<Tag> tags = Arrays.asList(new Tag[] {t1, t2, t3, t4, t5});
				
//		for (int i = 0; i < 5; i++) {
//			try {
//				Tag t = tDAO.adicionaOuBuscaTagComNome("Tag "+(i+1));
//				tags.add(t);
//			} catch (NullPointerException e) {
//				System.out.println("Deu pau!");
//			}
//			
//		}
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Conta de agua ");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setValor(new BigDecimal("123.32"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		movimentacao.setTags(tags);
		mDAO.adiciona(movimentacao);



		em.getTransaction().commit();
		em.close();
	}

}
