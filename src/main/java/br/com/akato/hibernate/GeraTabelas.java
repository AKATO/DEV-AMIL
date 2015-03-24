package br.com.akato.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class GeraTabelas {
	@SuppressWarnings("deprecation")
	public static void main(String[]Args){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
		cfg.addAnnotatedClass(Pessoa.class);
		cfg.addAnnotatedClass(Endereco.class);
	
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		
	}
}
