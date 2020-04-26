package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_DOADOR")
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
public class Doador {

	@Id
	@Column(name = "cd_doador")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigoDoador;

	@Column(name = "nm_doador", nullable = false, length = 100)
	private String nome;

	@OneToMany(mappedBy = "doador", cascade = CascadeType.ALL)
	private List<Doacao> doacoes = new ArrayList<Doacao>();

	@ManyToMany(mappedBy = "doadores")
	private List<Hospital> hospitais;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_criacao")
	private Calendar dataCriacao = Calendar.getInstance();

	public Doador(String nome, List<Hospital> hospitais) {
		this.nome = nome;
		this.hospitais = hospitais;
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
