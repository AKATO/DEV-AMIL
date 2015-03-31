package br.com.akato.hibernate.proxy;

public class MyFakeList <T>{
	private Object[] objetos = new Object[10];
	private int size = 0;
	
	public void add(T t){
		this.objetos[size] = t;
		size++;
	}
	public int getSize(){
		return this.size;
	}
	@SuppressWarnings("unchecked")
	public T get(int ref){
		return (T) this.objetos[ref];
	}
}
