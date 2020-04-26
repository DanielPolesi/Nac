package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.DoacaoDAO;
import br.com.fiap.jpa.dao.DoadorDAO;
import br.com.fiap.jpa.dao.ReceptorDAO;
import br.com.fiap.jpa.dao.impl.DoacaoDAOImpl;
import br.com.fiap.jpa.dao.impl.DoadorDAOImpl;
import br.com.fiap.jpa.dao.impl.ReceptorDAOImpl;
import br.com.fiap.jpa.entity.Doacao;
import br.com.fiap.jpa.entity.Doador;
import br.com.fiap.jpa.entity.Receptor;
import br.com.fiap.jpa.entity.TipoOrgao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		DoadorDAO doadorDAO = new DoadorDAOImpl(em);
		ReceptorDAO receptorDAO = new ReceptorDAOImpl(em);
		DoacaoDAO doacaoDAO = new DoacaoDAOImpl(em);

		Doador doador = new Doador("Nicholas Kuchiniski");
		Receptor receptor = new Receptor("Lucas Barros");
		Doacao doacao = new Doacao(doador, receptor, TipoOrgao.CORACAO);

		try {
			doadorDAO.cadastrar(doador);
			receptorDAO.cadastrar(receptor);
			doacaoDAO.cadastrar(doacao);

			doadorDAO.commit();
			receptorDAO.commit();
			doacaoDAO.commit();
		} catch (CommitException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
