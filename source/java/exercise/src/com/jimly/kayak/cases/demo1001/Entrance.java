package com.jimly.kayak.cases.demo1001;

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


/**
 * 执行结果：
 *	 Person say
	Women cook
	Man work
	People zhangsan walk
	man work is:IT
	woman cook is:noodle
 * */
