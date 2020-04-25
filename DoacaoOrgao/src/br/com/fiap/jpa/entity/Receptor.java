package br.com.fiap.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TB_DOADOR")
@SequenceGenerator(name="doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
public class Receptor {
	
	@Id
	@Column(name="cd_receptor")
	@GeneratedValue(generator="receptor", strategy = GenerationType.SEQUENCE)
	private int codigoReceptor;

	
	@Column(name="nm_receptor", nullable = false, length = 100)
	private String nome;

	
	@Column(name="cd_orgao_receptor")
	private int codigoOrgaoReceptor;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_orgao_receptor")
	private TipoOrgao orgReceptor; //descricao_orgao_receptor Enum

	@OneToMany(mappedBy = "TB_DOADOR")
	private Set<Doacao> doacoes;
	
	
	
	
	
	public int getCodigoReceptor() {
		return codigoReceptor;
	}

	public void setCodigoReceptor(int codigoReceptor) {
		this.codigoReceptor = codigoReceptor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoOrgaoReceptor() {
		return codigoOrgaoReceptor;
	}

	public void setCodigoOrgaoReceptor(int codigoOrgaoReceptor) {
		this.codigoOrgaoReceptor = codigoOrgaoReceptor;
	}

	public TipoOrgao getOrgReceptor() {
		return orgReceptor;
	}

	public void setOrgReceptor(TipoOrgao orgReceptor) {
		this.orgReceptor = orgReceptor;
	}
}

