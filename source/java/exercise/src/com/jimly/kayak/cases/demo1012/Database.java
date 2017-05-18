package com.jimly.kayak.cases.demo1012;


/**
 * 数据库公用接口
 * */
public interface Database {

	public void connect();
	
	public void insert();
	
	public void delete();
	
	public void update();
	
	public void select();
	
	public void close();
	
}
