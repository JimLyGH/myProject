package com.jimly.kayak.year;

public class Worker extends Person{

	public Worker() {
		super.work();
	}
	
	public String say(String name) {
		System.out.println("Worker " + name + " say");
		return name;
	}
	
	
}
