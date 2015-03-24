package br.com.akato.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.akato.modelo.Produto;


public class GeraTabelas {
	public static void main(String[]Args){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		
		
	}
}
