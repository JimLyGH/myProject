package com.jimly.kayak.cases.demo1001;

public abstract class People {
	private String name; 
	
	public People(String name) {
		this.name = name;
	}
	
	public abstract void say();
	
	public void walk() {
		System.out.println("People " + name + " walk");
	}
	
}
