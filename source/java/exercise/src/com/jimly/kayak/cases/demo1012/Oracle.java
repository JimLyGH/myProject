package com.jimly.kayak.cases.demo1012;

public class Oracle implements Database{

	@Override
	public void connect() {
		System.out.println("Oracle database connected...");
	}

	@Override
	public void insert() {
		System.out.println("Oracle database insert");
	}

	@Override
	public void delete() {
		System.out.println("Oracle database delete");
	}

	@Override
	public void update() {
		System.out.println("Oracle database update");
	}

	@Override
	public void select() {
		System.out.println("Oracle database select");
	}

	@Override
	public void close() {
		System.out.println("Oracle database close!!!");
	}

}
