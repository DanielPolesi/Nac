package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@Column(name = "nm_endereco", nullable = false, length = 100)
	private String endereco;

	@ManyToMany(mappedBy = "hospital")
	private List<Doador> doadores;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodigoHospital() {
		return codigoHospital;
	}
	
	
	
		
}
