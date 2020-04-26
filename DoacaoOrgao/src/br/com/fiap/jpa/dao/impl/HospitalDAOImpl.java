package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.HospitalDAO;
import br.com.fiap.jpa.entity.Hospital;

public class HospitalDAOImpl extends GenericDAOImpl<Hospital, Integer> implements HospitalDAO {
	public HospitalDAOImpl(EntityManager em) {
		super(em);
	}
}
