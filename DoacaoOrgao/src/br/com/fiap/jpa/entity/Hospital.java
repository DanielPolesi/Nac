package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_HOSPITAL")
@SequenceGenerator(name="hospital", sequenceName = "SQ_TB_HOSPITAL", allocationSize = 1)
public class Hospital {

	@Id
	@Column(name="cd_hospital")
	@GeneratedValue(generator="hospital", strategy = GenerationType.SEQUENCE)
	private int codigoHospital;

	@Column(name = "nm_hospital", nullable = false, length = 100)
	private String nome;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_HOSPITAL_DOADOR",
			joinColumns = @JoinColumn(name="cd_hospital"),
			inverseJoinColumns = @JoinColumn(name="cd_doador"))
	private List<Doador> doadores;

	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_endereco")
	private Endereco endereco;

	public Hospital(String nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getCodigoHospital() {
		return codigoHospital;
	}
	
	
	
		
}
