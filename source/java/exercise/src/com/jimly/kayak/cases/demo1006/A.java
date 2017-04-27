package com.jimly.kayak.cases.demo1006;

@SuppressWarnings("unused")
public class A {

	private int a = getA();
	private static int aa = getAA();	//与静态代码块调换顺序,看效果
	
	{
		System.out.println("初始化非静态代码块A");
	}
	
	static {
		System.out.println("初始化【静态】代码块 A");
	}
	
	public A() {
		System.out.println("-->初始化A构造函数");
	}
	
	public static int methodA() {
		System.out.println("【静态】方法A");
		return 1;
	}
	
	public int getA() {
		System.out.println("初始化变量a");
		return 1;
	}
	
	public static int getAA() {
		System.out.println("初始化【静态】变量aa");
		return 1;
	}
	
	public static void main(String[] args) {
		
		System.out.println("main start");
		C c = new C();
		System.out.println("------------");
		c = new C();
		System.out.println("main end");

	}
	
	
	/**
	 * 运行结果：
	 * 
	 * 	初始化【静态】变量aa
		初始化【静态】代码块 A
		初始【静态】代码块 B
		初始化【静态】变量bb
		初始化【静态】变量cc
		初始化【静态】代码块 C
		main start
		初始化变量a
		初始化非静态代码块A
		-->初始化A构造函数
		初始化非静态代码块B
		初始化变量b
		-->初始化B构造函数
		初始化非静态代码块C
		初始化变量c
		-->初始化C构造函数
		------------
		初始化变量a
		初始化非静态代码块A
		-->初始化A构造函数
		初始化非静态代码块B
		初始化变量b
		-->初始化B构造函数
		初始化非静态代码块C
		初始化变量c
	 * 
	 * */
}


@SuppressWarnings("unused")
class B extends A {
	
	{
		System.out.println("初始化非静态代码块B");
	}
	
	private int b = getB();
	
	static {
		System.out.println("初始【静态】代码块 B");
	}
	
	private static int bb = getBB();
	
	public B() {
		System.out.println("-->初始化B构造函数");
	}
	
	public static int methodB() {
		System.out.println("【静态】方法B");
		return 1;
	}
	
	public int getB() {
		System.out.println("初始化变量b");
		return 1;
	}
	
	public static int getBB() {
		System.out.println("初始化【静态】变量bb");
		return 1;
	}
}


@SuppressWarnings("unused")
class C extends B {
	private static int cc = getCC();
	
	{
		System.out.println("初始化非静态代码块C");
	}
	
	static {
		System.out.println("初始化【静态】代码块 C");
	}
	
	private int c = getC();	
	
	public C() {
		System.out.println("-->初始化C构造函数");
	}
	
	public static int methodC() {
		System.out.println("【静态】方法C");
		return 1;
	}
	
	public int getC() {
		System.out.println("初始化变量c");
		return 1;
	}
	
	public static int getCC() {
		System.out.println("初始化【静态】变量cc");
		return 1;
	}
}
