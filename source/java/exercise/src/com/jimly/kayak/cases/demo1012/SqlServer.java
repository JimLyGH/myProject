package com.jimly.kayak.cases.demo1012;

public class SqlServer implements Database{

	@Override
	public void connect() {
		System.out.println("SqlServer database connected...");
	}

	@Override
	public void insert() {
		System.out.println("SqlServer database insert");
	}

	@Override
	public void delete() {
		System.out.println("SqlServer database delete");
	}

	@Override
	public void update() {
		System.out.println("SqlServer database update");
	}

	@Override
	public void select() {
		System.out.println("SqlServer database select");
	}

	@Override
	public void close() {
		System.out.println("SqlServer database close!!!");
	}
	
}
