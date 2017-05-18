package com.jimly.kayak.cases.demo1012;

public class Entrance {

	public static void main(String[] args) {
	
		Entrance entrance = new Entrance();
		
		System.out.println("##########	使用接口	##########");
		entrance.useDatabase(new Mysql());
		entrance.useDatabase(new Oracle());
		
		System.out.println("##########	使用实现类	##########");
		entrance.useDatabase(new Mysql());
		entrance.useDatabase(new Oracle());
	}
	
	
	//1：使用接口
	public void useDatabase (Database database) {
		database.connect();
		database.insert();
		database.close();
	}
	
	/**
	 * ################################################################
	 * ################################################################
	 * ################################################################
	 * */
	
	//2：使用实现类
	public void useDatabase (Mysql mysql) {
		mysql.connect();
		mysql.insert();
		mysql.close();
	}
	
	public void useDatabase (Oracle oracle) {
		oracle.connect();
		oracle.insert();
		oracle.close();
	}
	
}
