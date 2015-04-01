package br.com.akato.hibernate;

import java.util.List;

import org.hibernate.Session;

public class PessoaDAO {
	
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public PessoaDAO(Session session){
		this.session = session;
		
	}
	
	public void salva(Pessoa p){
		this.session.save(p);
		this.salvaEndereco(p);
	}
	
	private void salvaEndereco(Pessoa p){
		for(Endereco endereco : p.getEnderecos()){
			this.session.save(endereco);
		}
	}
	
	public void remove(Pessoa p){
		this.session.delete(p);
	}
	
	public Pessoa busca(Long ID){
		return (Pessoa) this.session.load(Pessoa.class, ID);
	}
	public void atualiza(Pessoa p){
		this.session.update(p);
	}
	
	public List<Pessoa> listaTudo(){
		return this.session.createCriteria(Pessoa.class).list();
		//retorna a lista toda
	}


}
