package com.jimly.kayak.entity;

public class Worker extends Person{

	public Worker() {
		super.work();
	}
	
	public String say(String name) {
		System.out.println("Worker " + name + " say");
		return name;
	}
	
	
}
