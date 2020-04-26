package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.DoacaoDAO;
import br.com.fiap.jpa.dao.DoadorDAO;
import br.com.fiap.jpa.dao.EnderecoDAO;
import br.com.fiap.jpa.dao.HospitalDAO;
import br.com.fiap.jpa.dao.ReceptorDAO;
import br.com.fiap.jpa.dao.impl.DoacaoDAOImpl;
import br.com.fiap.jpa.dao.impl.DoadorDAOImpl;
import br.com.fiap.jpa.dao.impl.EnderecoDAOImpl;
import br.com.fiap.jpa.dao.impl.HospitalDAOImpl;
import br.com.fiap.jpa.dao.impl.ReceptorDAOImpl;
import br.com.fiap.jpa.entity.Doacao;
import br.com.fiap.jpa.entity.Doador;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Hospital;
import br.com.fiap.jpa.entity.Receptor;
import br.com.fiap.jpa.entity.TipoOrgao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		EnderecoDAO enderecoDAO = new EnderecoDAOImpl(em);
		HospitalDAO hospitalDAO = new HospitalDAOImpl(em);
		DoadorDAO doadorDAO = new DoadorDAOImpl(em);
		ReceptorDAO receptorDAO = new ReceptorDAOImpl(em);
		DoacaoDAO doacaoDAO = new DoacaoDAOImpl(em);

		List<Hospital> hospitais = new ArrayList<Hospital>();

		Endereco endereco = new Endereco("Avenida Paulista", "São Paulo", "Apto 10", "SP", 17, "Consolação",
				"01311-922");
		Hospital hospital = new Hospital("Santa Marcelina", endereco);
		hospitais.add(hospital);
		Doador doador = new Doador("Nicholas Kuchiniski", hospitais);
		Receptor receptor = new Receptor("Lucas Barros");
		Doacao doacao = new Doacao(doador, receptor, TipoOrgao.CORACAO);

		try {
			enderecoDAO.cadastrar(endereco);
			hospitalDAO.cadastrar(hospital);
			doadorDAO.cadastrar(doador);
			receptorDAO.cadastrar(receptor);
			doacaoDAO.cadastrar(doacao);

			enderecoDAO.commit();
			hospitalDAO.commit();
			doadorDAO.commit();
			receptorDAO.commit();
			doacaoDAO.commit();
		} catch (CommitException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
