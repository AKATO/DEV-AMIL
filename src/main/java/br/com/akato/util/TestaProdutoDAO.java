package br.com.akato.util;

import org.hibernate.Session;

import br.com.akato.dao.ProdutoDAO;
import br.com.akato.modelo.Produto;


public class TestaProdutoDAO {
	
	public static void main(String[]Args){
		Session session = new HibernateUtil().getSession();
		Produto p = new Produto();
		ProdutoDAO dao = new ProdutoDAO(session);
		
		//populando os dados aqui...
		
//		p.setNome("Relogio Swatch");
//		p.setDescricao("Swatch sweeden skelleton model");
//		
//		Calendar data = Calendar.getInstance();
//		data.set(Calendar.DATE, 11);
//		data.set(Calendar.MONTH, 04);
//		data.set(Calendar.YEAR, 2014);
//		
//		p.setDataInicioVenda(data);
//		p.setPreco(97.60);	
//		
		
		//session.beginTransaction();
//		dao.salva(p);
		//dao.busca(new Long(2));
//		List<Produto> l = (List<Produto>)dao.precoMaiorQue(2.00);
		
		for (Produto pi : dao.precoMaiorQue(2.10)) {
//			System.out.println(pi.getNome());
		}
		
		
		
		
//		session.getTransaction().commit();
		
//		System.out.println(" Foi adicionado o produto : " + p.getNome());
		
		session.close();

//		System.out.println(" Foi adicionado o produto : " + p.getNome());
		
	}
}
