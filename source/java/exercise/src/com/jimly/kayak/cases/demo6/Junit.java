package com.jimly.kayak.cases.demo6;

import org.junit.Test;


/**
 * 1：JUnit测试
 * 2：JAVA断言的两种使用方式
 * */
public class Junit {
	
	@Test
	public void test() {
		System.out.println("test start");
		
		int i = 10;
		
		assert i > 20 : "[Error] i=" + i;
		
		System.out.println("test end");
	}
	
	@Test
	public void test1() {
		System.out.println("test1 start");
		
		int i = 10;
		
		System.out.println("断言1前");
		
		assert i > 5 : "1:" + i;
		
		System.out.println("断言1后,断言2前");
		
		assert i > 15;
		
		System.out.println("断言2后");
		
		System.out.println("test1 end");
	}
	
	
	@Test
	public void test2() {
		System.out.println("test2 start");
		
		int i = 5;
		
		System.out.println("断言前");
		
		assert i > 0;
		
		System.out.println("断言后");
		
		System.out.println("test2 end");
	}

}
