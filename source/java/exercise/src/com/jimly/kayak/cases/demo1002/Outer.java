package com.jimly.kayak.cases.demo1002;

/**
 * 静态方法中没有this,因此ERROR1和ERROR2处会编译出错
 * */
public class Outer {
	private String name;
	
	public Outer() {
		this.name = "zhangsan";
	}
	
	class Inner{
		public Inner() {
			System.out.println("inner init");
		}
	}
	
	public static void foo() {
		System.out.println("foo");
		new Outer().new Inner();
		
//		new Inner();	//ERROR1
	}
	
	public void bar() {
		System.out.println(name + " bar");	//内部类可以使用外部类的变量(包括私有变量)
		new Inner();	//等价于this.new Inner();
	}
	
	public static void main(String[] args) {
		System.out.println("#############");
		new Outer().new Inner();
//		new Inner();	//ERROR2
		
		System.out.println("#############");
		Outer.foo();
		
		System.out.println("#############");
		new Outer().bar();
	}

}
