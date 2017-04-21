package com.jimly.kayak.cases.demo5;

/**
 * 匿名内部类可以继承其他类(case1),可以实现接口(case2)
 * */
public class Entrance {

	public static void main(String[] args) {
		
		//case1
		A a = new A(){
			public void a() {
				System.out.println("aaa");	//重写a方法
			}
		};
		
		a.a();
		a.z();
		
		System.out.println("------------------------");
		
		//case2
		B b = new B() {
			@Override
			public void b() {
				System.out.println("BBB");
			}
		};
		
		b.b();
	}
	
}


/**
 * 执行结果
 * 	aaa
	ZZZ
	------------------------
	BBB
 * */
