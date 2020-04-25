package br.com.fiap.jpa.entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_DOACAO")
@SequenceGenerator(name="doacao", sequenceName = "SQ_TB_DOACAO", allocationSize = 1)
public class Doacao {
	
	
	@Id
	@Column(name="cd_tramite")
	@GeneratedValue(generator="doacao", strategy = GenerationType.SEQUENCE)
	private int tramite;
	
	@Column(name="ds_tramite")
	private String descricao;
	
	@ManyToMany(mappedBy = "tramiteDoacao")
	Set<Doador> tramite_relacao;

	@ManyToOne
	@JoinColumn(name = "receptor_id", nullable=false)
	private Receptor receptor;
	
	
	
	
	
	public Set<Doador> getTramite_relacao() {
		return tramite_relacao;
	}

	public void setTramite_relacao(Set<Doador> tramite_relacao) {
		this.tramite_relacao = tramite_relacao;
	}

	public int getTramite() {
		return tramite;
	}

	public void setTramite(int tramite) {
		this.tramite = tramite;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
