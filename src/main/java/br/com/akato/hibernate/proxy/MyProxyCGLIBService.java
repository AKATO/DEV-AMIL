package br.com.akato.hibernate.proxy;

import net.sf.cglib.proxy.Enhancer;
import br.com.akato.hibernate.Pessoa;

public class MyProxyCGLIBService<T> {
	public MyFakeList<T> criarListaFake(){
		final MyFakeList<T> exemplo = new MyFakeList<T>();
		MyInterceptor c = new MyInterceptor(exemplo);
		MyFakeList objetoProxiado = (MyFakeList) Enhancer.create(MyFakeList.class,c);
		return objetoProxiado;
	}
	
	public static void main(String[] args) {
		MyFakeList<Pessoa> list = new MyProxyCGLIBService<Pessoa>().criarListaFake();
		list.add(new Pessoa(1l));
		list.add(new Pessoa(2l));
		list.add(new Pessoa(3l));
		int qtdeItens = list.getSize();
		Pessoa p = list.get(2);
		System.out.println(String.format("Id: %d ", p.getId()));
		System.out.println(String.format("Qtde Itens na lista: %d ", qtdeItens));
		}
}
