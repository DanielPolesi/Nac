package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ReceptorDAO;
import br.com.fiap.jpa.entity.Receptor;

public class ReceptorDAOImpl extends GenericDAOImpl<Receptor, Integer> implements ReceptorDAO  {

	public ReceptorDAOImpl(EntityManager em) {
		super(em);
	}

}
