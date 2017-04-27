package com.jimly.kayak.cases.demo1003;

public class Class3 extends Abstract3{

	private String name;
	
	public Class3(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void sleep() {
		System.out.println(name + " sleep");
	}
}
