package com.jimly.kayak.year;

import java.lang.reflect.Method;

import org.junit.Test;


public class Junit {

	@Test
	public void test1() {
		System.out.println("########## TEST 1  ##########");
		Person.work();
		System.out.println("-----------------------------------------------------");
		Worker worker = new Worker();
		worker.say("lisi");
	}
	
	@Test
	public void test2() {
		System.out.println("########## TEST 2  ##########");
		char a = '号';
		System.out.println(a);
		
		char b = 97;
		System.out.println(b);
	}

	@Test
	public void test3() {
		System.out.println("########## TEST 3  ##########");
		Runtime.getRuntime().gc();
		System.gc();
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void test4() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("########## TEST 4  ##########");
		Class cla = Class.forName("com.jimly.kayak.year.Person");
		Person p = (Person) cla.newInstance();
		
		Method[] m = cla.getMethods();
		System.out.println(m[0].getName());
		
		System.out.println(p.say("zhangsan"));
		Person p1 = new Person();
		System.out.println(p1.say("lisi"));
	}
	
	@Test
	public void test5() {
		System.out.println("########## TEST 5  ##########");
		Integer a = 3;	//自动装箱,实际Integer a = new Integer(3);
		int b = a;		//自动拆箱,实际int b = a.intValue();
		System.out.println("b = " + b);
	}
	
	@Test
	public void test6() {
		System.out.println("########## TEST 6  ##########");
		Integer a = new Integer(3);
		Integer b = 3;
		int c = 3;
		System.out.println("a == b :" + (a == b));
		System.out.println("a == c :" + (a == c));
		System.out.println("b == c :" + (b == c));
	}
	
	@Test
	public void test7() {
		System.out.println("########## TEST 7  ##########");
		//-128 <= value <= 127 
		Integer x = new Integer(127);
		Integer y = new Integer(127);
		System.out.println("x == y :" + (x == y));
		System.out.println("x == y :" + (Integer.valueOf(x) == Integer.valueOf(y)));
		
		//value < -128 || value > 127
		Integer m = new Integer(128);
		Integer n = new Integer(128);
		System.out.println("m == n :" + (m == n));
		System.out.println("m == n :" + (Integer.valueOf(m) == Integer.valueOf(n)));
	}
	
	@Test
	public void test8() {

	}
	
	@Test
	public void test9() {

	}
	
	@Test
	public void test10() {

	}
	
}