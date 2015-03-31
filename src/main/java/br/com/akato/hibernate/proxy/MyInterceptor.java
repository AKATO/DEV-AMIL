package br.com.akato.hibernate.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor {
	public MyInterceptor(){}
	
	public MyInterceptor(MyFakeList fakeList){
		this();
		this.fakeList = fakeList;
		
	}
	
	private MyFakeList fakeList;
	
	public Object intercept(Object object, Method method, Object[]args,MethodProxy methodProxy) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		System.out.println("--------------Meu Proxy em Ação--------------------");
		System.out.println("Excutando método interceptado : " + method.getName());
		return method.invoke(fakeList, args);
	}
}
