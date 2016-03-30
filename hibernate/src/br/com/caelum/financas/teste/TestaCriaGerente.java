package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.GerenteDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Endereco;
import br.com.caelum.financas.modelo.Gerente;

public class TestaCriaGerente {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cDAO = new ContaDAO(em);
		GerenteDAO gDAO = new GerenteDAO(em);
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Belo Horizonte");
		endereco.setEstado("MG");
		endereco.setRua("Rua da Bahia");
				
//		Gerente gerente = new Gerente();
//		gerente.setNome("Odelirio");
//		gerente.setTelefone("654987321");
//		gerente.setEndereco(endereco);
		
		Gerente gerente = gDAO.busca(3);
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Fulano Souza");
		conta.setAgencia("9875");
		conta.setBanco("Caixa Economica");
		conta.setNumero("987546-5");
		conta.setGerente(gerente);
		
		//em.persist(gerente);
		em.persist(conta);
			
		em.getTransaction().commit();
		em.close();
		
		
	}

}
