package com.jimly.kayak.proxy;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(int id, String name) {
		System.out.println("id = " + id + ", name = " + name + " insert");
	}

	@Override
	public void delete(int id) {
		System.out.println("id = " + id + " delete");		
	}

	@Override
	public void update(int id, String name) {
		System.out.println("id = " + id + ", name = " + name + " update");		
	}

	@Override
	public void query(int id) {
		System.out.println("id = " + id + " query");		
	}

}
