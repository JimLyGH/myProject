package com.jimly.kayak.cases.demo1;

public class Person extends People implements Man, Women{

	public Person(String name) {
		super(name);
	}

	@Override
	public void say() {
		System.out.println("Person say");
	}

	@Override
	public void cook() {
		System.out.println("Women cook");
	}

	@Override
	public void work() {
		System.out.println("Man work");
	}

}
