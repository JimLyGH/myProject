package com.jimly.kayak.cases.demo3;


/**
 * 1：接口支持多继承,类(普通类和抽象类)不支持多继承
 * 2：一个类继承了抽象类或实现了某个接口,都要对其中的抽象方法进行全部实现,否则需要被声明为抽象类
 * 3：接口比抽象类更抽象
 * 4：抽象类和接口都不能实例化,但是可以定义抽象类和接口的引用
 * 5：有抽象方法的类必须定义为抽象类,而抽象类未必要有抽象方法
 * */
public class Entrance {

	public static void main(String[] args) {
		
		System.out.println("########## CLASS ONE  ##########");
		Man man = new Class1();
		man.work();
		
		Women women = new Class1();
		women.cook();
		
		People people = new Class1();
		people.head();
		
		Class1 cla1 = new Class1();
		cla1.country();
		
		System.out.println("########## CLASS TWO  ##########");
		Class2 cla2 = new Class2();
		cla2.eat();
		cla2.driver();
		cla2.study();
		
		System.out.println("########## CLASS THREE  ##########");
		Abstract3 abstract3 = new Class3("zhangsan");
		abstract3.read();
		abstract3.sleep();
		
		
	}
	
}
