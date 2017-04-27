package com.jimly.kayak.cases.demo1004;

/**
 * 1：接口可以继承接口,接口继承支持多继承
 * 2：抽象类可以实现接口
 * 3：抽象类可以继承抽象类也可以继承具体类
 * */
public class Entrance {

	public static void main(String[] args) {
		
		Abstract1 abstract1 = new Abstract1() {

			@Override
			public void work() {
				System.out.println("Interface2 work");
			}
			
			@Override
			public void eat() {
				System.out.println("Interface1 eat");
			}
			
			@Override
			public void driver() {
				System.out.println("Abstract1 driver");
			}

			@Override
			public void cook() {
				System.out.println("Abstract2 cook");
			}
			
			
		};
		
		abstract1.work();
		abstract1.eat();
		abstract1.driver();
		abstract1.cook();
		abstract1.walk();
		abstract1.sleep();
		
	}
	
}


/**
 * 执行结果：
 * 	Interface2 work
	Interface1 eat
	Abstract1 driver
	Abstract2 cook
	Class1 walk
	Class2 sleep
 * */
