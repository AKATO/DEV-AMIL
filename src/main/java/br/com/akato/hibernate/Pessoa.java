package br.com.akato.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	@Id
	@GeneratedValue
	@Column(name="pessoa_id")
	private Long id;
		
	private String nome;
	private Long cpf;
	
	@OneToMany(mappedBy="pessoa")
	private Set<Endereco> enderecos;
	
	
	
	public Pessoa(String nome,Long cpf){
		this.nome = nome;
		this.cpf = cpf;
		this.enderecos = new HashSet<Endereco>();
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Set<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}
	public Pessoa(){
		
	}
}
