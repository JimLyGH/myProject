package com.jimly.kayak.proxy;

public interface UserDao {

	public void add(int id, String name);

	public void delete(int id);
	
	public void update(int id, String name);
	
	public void query(int id);
}
