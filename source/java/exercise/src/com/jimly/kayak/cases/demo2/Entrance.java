package com.jimly.kayak.cases.demo2;

import com.jimly.kayak.cases.demo2.OuterClass.InnerClass2;
import com.jimly.kayak.cases.demo2.OuterClass.InnerClass1;

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
		
	}
	

}
