package com.jimly.kayak.cases.two;

/**
 * 静态方法中没有this,因此ERROR1和ERROR2处会编译出错
 * */
public class Outer {
	
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
		System.out.println("bar");
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
