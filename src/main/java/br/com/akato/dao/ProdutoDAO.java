package br.com.akato.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.akato.modelo.Produto;

public class ProdutoDAO {
	private Session session;
	
	public ProdutoDAO(Session session){
		this.session = session;
		
	}
	
	public void salva(Produto p){
		this.session.save(p);
	}
	
	public void remove(Produto p){
		this.session.delete(p);
	}
	
	public Produto busca(Long ID){
		return (Produto) this.session.load(Produto.class, ID);
	}
	public void atualiza(Produto p){
		this.session.update(p);
	}
	
	public List<Produto> listaTudo(){
		return this.session.createCriteria(Produto.class).list();
		//retorna a lista toda
	}
	public List<Produto> pagina(int inicio,int quantia){
		return this.session.createCriteria(Produto.class).setMaxResults(quantia).setFirstResult(inicio).list();
		//retorna em quantidades
	}
	public List<Produto> precoMaiorQue(double preco){
		Query query = this.session.createQuery("from Produto where preco > :preco");
		query.setDouble("preco",preco);
		return query.list();
		
	}
}
