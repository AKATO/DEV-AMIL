package br.com.akato.hibernate;

import org.hibernate.Session;

public class TestaPessoaDAO {
	public static void main(String[]Args){
		executaProxyamentoParaAcessarObjetoNaoCarregado();
	}
	static void executaProxyamentoParaAcessarObjetoNaoCarregado(){
		Session session = new HibernateUtil().getSession();
		System.out.println("Sessao Aberta");
		PessoaDAO pessoadao = new PessoaDAO(session);
		Pessoa pessoa = pessoadao.busca(3l);
		Object enderecoProxy = pessoa.getEnderecos();
		System.out.println("O objeto de persistencia com inicializacao `tardia` esta sendo proxyado");
		org.hibernate.proxy.HibernateProxy objeto = (org.hibernate.proxy.HibernateProxy) pessoa;
		System.out.println("Para o o objet Pessoa foi gerado um objeto Proxy" + objeto.getClass());
		org.hibernate.collection.internal.PersistentSet persistentSet = (org.hibernate.collection.internal.PersistentSet) enderecoProxy;
		System.out.println("O Set de Enderecos foi proxiado pela classe : " + persistentSet.getClass() + " , valor : "+ persistentSet.toString());
		session.close();
		System.out.println("Sessao Fechada");
		System.out.println(""+pessoa.getNome()+":");
		for(Endereco endereco:pessoa.getEnderecos()){
			System.out.println(" Endereco de Id : " + endereco.getId() +", :  " + endereco.getLogradouro() + endereco.getNumero());
		}
	}
	static void lancaLazyException(){
		Session session = new HibernateUtil().getSession();
		PessoaDAO pessoadao = new PessoaDAO(session);
		Pessoa pessoa = pessoadao.busca(3l);
		session.close();
		System.out.println("-------------------------------");
		System.out.println("Sessao Fechada");
		System.out.println(""+pessoa.getNome()+":");
		for(Endereco endereco:pessoa.getEnderecos()){
			System.out.println(" Endereco de Id : " + endereco.getId() +", :  " + endereco.getLogradouro() + endereco.getNumero());
		}

	}


}

