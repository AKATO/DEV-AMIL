package br.com.akato.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory factory;
	
	static{ 
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Pessoa.class);
		cfg.addAnnotatedClass(Endereco.class);
		factory = cfg.buildSessionFactory();		
	}
	
	public Session getSession(){
		return factory.openSession();
	}
}
