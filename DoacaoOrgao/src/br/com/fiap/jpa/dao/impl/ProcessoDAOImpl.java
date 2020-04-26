package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProcessoDAO;
import br.com.fiap.jpa.entity.Processo;

public class ProcessoDAOImpl extends GenericDAOImpl<Processo, Integer> implements ProcessoDAO {

	public ProcessoDAOImpl(EntityManager em) {
		super(em);
	}

}
