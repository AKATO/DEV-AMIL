package br.com.akato.hibernate.proxy;

import br.com.akato.hibernate.Pessoa;

public class MyProxyCGLIBService<T> {
	public MyFakeList criarListaFake(){
		final MyInterceptor c = new MyInterceptor();
		MyFakeList objetoProxiado = (MyFakeList) Enhancer.create(MyFakeList.class,c);
		return objetoProxiado;
	}
	
	public static void main(String[] args) {
		MyFakeList<Pessoa> list = new MyProxyCGLIBService<Pessoa>().criarListaFake();
		list.add(new Pessoa(4l));
		list.add(new Pessoa(5l));
		list.add(new Pessoa(6l));
		int qtdeItens = list.getSize();
		Pessoa p = list.get(6);
		System.out.println(String.format("Id: %d ", p.getId()));
		System.out.println(String.format("Qtde Itens na lista: %d ", qtdeItens));
		}
}
