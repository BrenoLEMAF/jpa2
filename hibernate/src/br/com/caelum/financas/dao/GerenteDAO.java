package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Gerente;

public class GerenteDAO {
	private final DAO<Gerente> dao;
	private EntityManager em;

	public GerenteDAO(EntityManager em) {
		this.em = em;
		dao = new DAO<Gerente>(em, Gerente.class);
	}
	public Gerente busca(Integer id){
		return dao.busca(id);
	}
}
