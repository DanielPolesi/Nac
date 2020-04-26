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

// Processo é uma entidade de controle funciona como um documento proprio de autorização para cada doador
@Entity
@Table(name = "TB_PROCESSO")
@SequenceGenerator(name = "processo", sequenceName = "SQ_TB_PROCESSO", allocationSize = 1)
public class Processo {
	
	@Id
	@Column(name = "cd_processo")
	@GeneratedValue(generator = "processo", strategy = GenerationType.SEQUENCE)
	private int codigoProcesso;

	@Column(name = "status_processo")
	private boolean status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Calendar dataCriacao;
	
	@OneToOne(mappedBy = "processo", cascade = CascadeType.ALL)
	private Doador doador;
}
