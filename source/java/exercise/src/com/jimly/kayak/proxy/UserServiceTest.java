package com.jimly.kayak.proxy;


import java.lang.reflect.Proxy;

import org.junit.Test;

public class UserServiceTest {

	@Test
	public void testProxy() {
		UserDao userDao = new UserDaoImpl();	//产生一个被代理对象
		LogInteceptor li = new LogInteceptor();	//产生一个代理对象
		li.setTarget(userDao);	//设置userDao为被代理对象
		
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, li);
		
		System.out.println(userDaoProxy.getClass());
		
		userDaoProxy.add(1, "zhangsan");
		userDaoProxy.delete(1);
		userDaoProxy.update(1, "lisi");
		userDaoProxy.query(1);
		
	}
	
}
