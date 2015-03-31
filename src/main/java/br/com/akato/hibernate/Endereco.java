package br.com.akato.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="endereco")
public class Endereco {
	@Id
	@GeneratedValue
	@Column(name="endereco_id")
	private Long id;
	private String logradouro;
	private Long numero;
	@ManyToOne
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	
	public Endereco(String logradouro,Long numero){
		this.logradouro = logradouro;
		this.numero = numero;
	}
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
	public Endereco(){}
}
