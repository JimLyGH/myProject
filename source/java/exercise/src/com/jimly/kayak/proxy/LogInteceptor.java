package com.jimly.kayak.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInteceptor implements InvocationHandler{

	private Object target;	//被代理对象
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		beforeMethod(m);
		m.invoke(target, args);
		return null;
	}
	
	
	public void beforeMethod(Method m) {
		System.out.println(m.getName() + " start!!!");
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
