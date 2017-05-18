package com.jimly.kayak.cases.demo1012;

public class Mysql implements Database{

	@Override
	public void connect() {
		System.out.println("Mysql database connected...");
	}

	@Override
	public void insert() {
		System.out.println("Mysql database insert");
	}

	@Override
	public void delete() {
		System.out.println("Mysql database delete");
	}

	@Override
	public void update() {
		System.out.println("Mysql database update");
	}

	@Override
	public void select() {
		System.out.println("Mysql database select");
	}

	@Override
	public void close() {
		System.out.println("Mysql database close!!!");
	}
	
}
