package br.com.akato.hibernate.proxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {}{
	public Object intercept(Object object, Method method, Object[]args,MethodProxy methodProxy){
		System.out.println("--------------Meu Proxy em Ação--------------------");
		System.out.println("Excutando método interceptado : " + method.getName());
	}
}
