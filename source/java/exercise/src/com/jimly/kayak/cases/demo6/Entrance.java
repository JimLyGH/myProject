package com.jimly.kayak.cases.demo6;


/**
 * 类的加载顺序
 * */
@SuppressWarnings("unused")
public class Entrance {

	public static void main(String[] args) {
		
			C c = new C();
			System.out.println("------------");
			c = new C();
			
	}
	
}


/**
 * 执行结果：
 * 
 * 	初始化【静态】变量aa
	初始化【静态】代码块 A
	初始【静态】代码块 B
	初始化【静态】变量bb
	初始化【静态】变量cc
	初始化【静态】代码块 C
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
	-->初始化C构造函数
 * 
 * */
