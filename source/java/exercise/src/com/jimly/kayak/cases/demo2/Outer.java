package com.jimly.kayak.cases.demo2;

/**
 * ��̬������û��this,���ERROR1��ERROR2����������
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
		System.out.println(name + " bar");	//�ڲ������ʹ���ⲿ��ı���(����˽�б���)
		new Inner();	//�ȼ���this.new Inner();
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
