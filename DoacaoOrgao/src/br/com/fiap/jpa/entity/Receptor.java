package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RECEPTOR")
@SequenceGenerator(name = "receptor", sequenceName = "SQ_TB_RECEPTOR", allocationSize = 1)
public class Receptor {
	@Id
	@Column(name = "cd_receptor")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigoDoador;

	@Column(name = "nm_receptor", nullable = false, length = 100)
	private String nome;

	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
	private List<Doacao> doacoes = new ArrayList<Doacao>();

	public Receptor(String nome) {
		this.nome = nome;
	}

	public int getCodigoDoador() {
		return codigoDoador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
