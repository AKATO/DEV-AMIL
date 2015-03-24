package br.com.akato.util;

import java.util.Calendar;

import org.hibernate.Session;

import br.com.akato.modelo.Produto;

public class AdicionaProduto {
//	private HibernateUtil hibernate;

	public static void main(String[]Args){
		
		Produto p  = new Produto();
		p.setNome("Celular Motorola");
		p.setDescricao("SmartPhone RazorHD");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 9);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.YEAR, 2014);
		
		p.setDataInicioVenda(cal);
		p.setPreco(596.00);
		
		Session session = new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(p);
		
		session.getTransaction().commit();
		System.out.println("O produto adicionado foi : " + p.getNome());
	}
}
