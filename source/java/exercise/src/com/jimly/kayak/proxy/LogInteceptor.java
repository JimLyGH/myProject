package com.jimly.kayak.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * JDK实现动态代理
 * */
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
	
	
	//重构得到代理代码
	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	

}
