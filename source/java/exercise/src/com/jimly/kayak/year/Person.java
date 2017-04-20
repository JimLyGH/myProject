package com.jimly.kayak.year;

public class Person {

	private String name = "zhangsan";
	
	public String say(String name) {
		System.out.println("person " + name + " say");
		return name;
	}
	
	public static void work() {
		Person p = new Person();
		System.out.println(p.name + " work");
		p.say("zhangsan");
	}

	public void walk() {
		this.say("lisi");
	}
	
	
}
