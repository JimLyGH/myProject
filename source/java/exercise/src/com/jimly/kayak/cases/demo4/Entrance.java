package com.jimly.kayak.cases.demo4;

/**
 * 1���ӿڿ��Լ̳нӿ�,�ӿڼ̳�֧�ֶ�̳�
 * 2�����������ʵ�ֽӿ�
 * 3����������Լ̳г�����Ҳ���Լ̳о�����
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
