package com.jimly.kayak.cases.demo1009;

public class Child extends Parent{

	private String name = "child";
	
	public Child() {
		tellName();
		printName();
	}
	
	public void tellName() {
		System.out.println("Child tell:" + name);
	}
	
	public void printName() {
		System.out.println("Child print:" + name);
	}
	
	
}

class Parent {
	
	private String name = "parent";
	
	public Parent() {
		tellName();
		printName();
	}
	
	public void tellName() {
		System.out.println("Parent tell:" + name);
	}
	
	public void printName() {
		System.out.println("Parent print:" + name);
	}
	
}
