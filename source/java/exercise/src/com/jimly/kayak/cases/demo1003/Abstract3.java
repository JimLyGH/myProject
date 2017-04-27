package com.jimly.kayak.cases.demo1003;


public abstract class Abstract3 {

	private String name;
	
	public Abstract3(String name) {
		super();
		this.name = name;
	}
	
	public abstract void sleep();
	
	public void read() {
		System.out.println(this.name + " read");
	}
	
}
