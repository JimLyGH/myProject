package com.jimly.kayak.proxy;


/**
 * 静态代理
 * */
public class staticProxy implements UserDao{

	private UserDao userDao;
	
	public staticProxy() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public void add(int id, String name) {
		before();
		userDao.add(id, name);
		after();
	}

	@Override
	public void delete(int id) {
		before();
		userDao.delete(id);
		after();
	}

	@Override
	public void update(int id, String name) {
		before();
		userDao.update(id, name);
		after();
	}

	@Override
	public void query(int id) {
		before();
		userDao.query(id);
		after();
	}
	
	
	public void before() {
		System.out.println("before");
	}
	
	public void after() {
		System.out.println("after");
	}

}
