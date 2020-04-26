package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name = "endereco", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {

	@Id
	@Column(name = "cd_endereco")
	@GeneratedValue(generator = "endereco", strategy = GenerationType.SEQUENCE)
	private int codigoEndereco;

	@Column(name = "rua")
	private String rua;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "estado")
	private String estado;

	@Column(name = "numero_rua")
	private int numero;

	@Column(name = "nm_bairro")
	private String bairro;

	@Column(name = "nm_cep")
	private String cep;

	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Hospital hospital;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_criacao")
	private Calendar dataCriacao = Calendar.getInstance();

	public Endereco(String rua, String cidade, String complemento, String estado, int numero, String bairro,
			String cep) {
		this.rua = rua;
		this.cidade = cidade;
		this.complemento = complemento;
		this.estado = estado;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
