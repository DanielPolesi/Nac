package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DOACAO")
@SequenceGenerator(name = "doacao", sequenceName = "SQ_TB_DOACAO", allocationSize = 1)
public class Doacao {
	@Id
	@Column(name = "cd_doacao")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigoDoacao;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_doador", nullable = false)
	private Doador doador;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_receptor", nullable = false)
	private Receptor receptor;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_tipo_orgao")
	private TipoOrgao tipoOrgao;

	public Doacao(Doador doador, Receptor receptor, TipoOrgao tipoOrgao) {
		this.doador = doador;
		this.receptor = receptor;
		this.tipoOrgao = tipoOrgao;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public int getCodigoDoacao() {
		return codigoDoacao;
	}
}
