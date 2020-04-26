package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Processo é uma entidade de controle funciona como um documento proprio de autorização para cada doador
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
	private int cep;
	
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Doador doador;
	
	
}
