package com.jimly.kayak.proxy;


import org.junit.Test;

public class UserServiceTest {

	@Test
	public void jdkProxyTest() {
		System.out.println("############### jdkProxyTest ###############");
		UserDao userDao = new UserDaoImpl();	//产生一个被代理对象
		LogInteceptor li = new LogInteceptor();	//产生一个代理对象
		li.setTarget(userDao);	//设置userDao为被代理对象
		
		//UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, li);
		UserDao userDaoProxy = li.getProxy();
		
		System.out.println(userDaoProxy.getClass());
		
		userDaoProxy.add(1, "zhangsan");
		userDaoProxy.delete(1);
		userDaoProxy.update(1, "lisi");
		userDaoProxy.query(1);
	}
	
	
	@Test
	public void cglibProxyTest() {
		System.out.println("############### cglibProxyTest ###############");
		CGLibProxy cgLibProxy = new CGLibProxy();
		UserDao userDaoProxy = cgLibProxy.getProxy(UserDaoImpl.class);
		userDaoProxy.add(1, "wangwu");
	}
	
	
	@Test
	public void staticProxyTest() {
		System.out.println("############### staticProxyTest ###############");
		UserDao staticProxy = new staticProxy();
		staticProxy.add(1, "zhangsan");
	}
	
}
