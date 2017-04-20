package com.jimly.kayak.cases.demo2;

public class OuterClass {

	private String name;
	
	public OuterClass(String name) {
		this.name = name;
	}
	
	public void method() {
		new InnerClass1();
		new InnerClass2();
		System.out.println("OuterClass method");
	}
	
	public static void eat() {
		new OuterClass("zhangsan").new InnerClass1();
		new OuterClass("zhangsan").new InnerClass2();
		System.out.println("OuterClass eat");
	}
	
	class InnerClass1 {
		
		public InnerClass1() {
			System.out.println("InnerClass1 init " + name);
		}
		
		public void method() {
			System.out.println("InnerClass1 method");
		}
		
		public void say(String toName) {
			System.out.println(name + " say hello to " + toName);
		}
		
	}
	
	class InnerClass2{
		
		public InnerClass2() {
			System.out.println("InnerClass2 init " + name);
		}
		
		public void method() {
			System.out.println("InnerClass2 method");
		}
		
		public void work(String name) {
			System.out.println(name + " is working now");
		}
		
	}
	
	
}
