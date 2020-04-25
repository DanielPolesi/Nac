package br.com.fiap.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_DOADOR")
@SequenceGenerator(name="doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
public class Doador {

	@Id
	@Column(name="cd_doador")
	@GeneratedValue(generator="doador", strategy = GenerationType.SEQUENCE)
	private int codigoDoador;

	@Column(name="nm_doador", nullable = false, length = 100)
	private String nome;

	@Column(name="cd_orgao_doador")
	private int codigoOrgaoDoador;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_orgao_doador")
	private TipoOrgao orgDoador; //descricao_orgao_doador Enum
	
	@ManyToMany
	@JoinTable(
	name = "tramite_doacao",
	joinColumns = @JoinColumn(name = "cd_doador"),
	inverseJoinColumns = @JoinColumn(name = "cd_tramite"))
	Set<Doacao> tramiteDoacao;
	

	public int getCodigoDoador() {
		return codigoDoador;
	}
	public void setCodigoDoador(int codigoDoador) {
		this.codigoDoador = codigoDoador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigoOrgaoDoador() {
		return codigoOrgaoDoador;
	}
	public void setCodigoOrgaoDoador(int codigoOrgaoDoador) {
		this.codigoOrgaoDoador = codigoOrgaoDoador;
	}
	public TipoOrgao getOrgDoador() {
		return orgDoador;
	}
	public void setOrgDoador(TipoOrgao orgDoador) {
		this.orgDoador = orgDoador;
	}



}
