package com.jimly.kayak.cases.one;

public class Entrance {

	public static void main(String[] args) {
		
		Person p = new Person("zhangsan");
		
		p.say();
		p.cook();
		p.work();
		p.walk();
		
		System.out.println("man work is:" + Man.work);
		System.out.println("woman cook is:" + Women.cook);
		
//		System.out.println("man work is:" + p.work);
//		System.out.println("woman cook is:" + p.cook);
	}
	
}
