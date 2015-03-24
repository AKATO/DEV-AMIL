package br.com.akato.hibernate;

import org.hibernate.Session;

public class TestaPessoaDAO {
	public static void main(String[]Args){
		Session session = new HibernateUtil().getSession();
		Pessoa pessoa = new Pessoa("Arthur Kato",38742425875L);
		Endereco endereco = new Endereco("El.Grajau",292L);
		pessoa.addEndereco(endereco);
		PessoaDAO dao = new PessoaDAO(session);
		session.beginTransaction();
		dao.salva(pessoa);
		session.getTransaction().commit();
		System.out.println(" Foi adicionado a pessoa : " + pessoa.getNome());
		
		session.close();

		
	}

}
//System.out.println(" Foi adicionada a pessoa : " + p.getNome());


//pessoa.setNome("Arthur Kato");
//pessoa.setCpf(38742425875L);
//

