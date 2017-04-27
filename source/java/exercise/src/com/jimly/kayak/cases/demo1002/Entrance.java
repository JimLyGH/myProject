package com.jimly.kayak.cases.demo1002;

import com.jimly.kayak.cases.demo1002.OuterClass.InnerClass1;
import com.jimly.kayak.cases.demo1002.OuterClass.InnerClass2;
import com.jimly.kayak.cases.demo1002.Telphone.IPhone;
import com.jimly.kayak.cases.demo1002.Telphone.XiaoMi;

public class Entrance {
	
	public static void main(String[] args) {
		
		System.out.println("########## OuterClass  ##########");
		OuterClass outerClass = new OuterClass("zhangsan");
		outerClass.method();
		
		System.out.println("########## Innerclass1  ##########");
		InnerClass1 innerclass1 = outerClass.new InnerClass1();
		innerclass1.method();
		innerclass1.say("lisi");
		
		System.out.println("########## InnerClass2  ##########");
		InnerClass2 innerClass2 = outerClass.new InnerClass2();
		innerClass2.method();
		innerClass2.work("wangwu");
		
		System.out.println("########## 匿名内部类  ##########");
		Fruit fruit = new Fruit(1) {
			@Override
			public void apple() {
				System.out.println("eat " + this.getNum() + " apple");
			}
		};
		fruit.apple();
		
		Telphone tel = new Telphone(1) {
			public void company() {
				System.out.println("override company");
			}
		};
		tel.company();
		tel.call();
		
		System.out.println("########## 静态内部类  ##########");
		Telphone telphone = new Telphone(1);
		telphone.company();
		System.out.println("----------------------------");
		
		XiaoMi xiaoMi = new XiaoMi();
		System.out.println("uName:" + XiaoMi.uName);
		xiaoMi.company();
		System.out.println("----------------------------");
		
		IPhone iPhone = telphone.new IPhone();
		iPhone.company();
		System.out.println("----------------------------");
	}

}


/**
 * 执行结果：
 *	 ########## OuterClass  ##########
	InnerClass1 init zhangsan
	InnerClass2 init zhangsan
	OuterClass method
	########## Innerclass1  ##########
	InnerClass1 init zhangsan
	InnerClass1 method
	zhangsan say hello to lisi
	########## InnerClass2  ##########
	InnerClass2 init zhangsan
	InnerClass2 method
	wangwu is working now
	########## 匿名内部类  ##########
	eat 1 apple
	override company
	Telphone call
	########## 静态内部类  ##########
	Telphone
	----------------------------
	XiaoMi init leijun
	uName:leijun
	XiaoMi
	----------------------------
	1
	IPhone
	----------------------------
 * */
