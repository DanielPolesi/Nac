package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.DoacaoDAO;
import br.com.fiap.jpa.entity.Doacao;

public class DoacaoDAOImpl
					extends GenericDAOImpl<Doacao, Integer> implements DoacaoDAO {

	public DoacaoDAOImpl(EntityManager em) {
		super(em);
	}

}
