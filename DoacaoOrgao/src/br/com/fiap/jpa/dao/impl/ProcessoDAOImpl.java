package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProcessoDAO;
import br.com.fiap.jpa.entity.Endereco;

public class ProcessoDAOImpl extends GenericDAOImpl<Endereco, Integer> implements ProcessoDAO {

	public ProcessoDAOImpl(EntityManager em) {
		super(em);
	}

}
