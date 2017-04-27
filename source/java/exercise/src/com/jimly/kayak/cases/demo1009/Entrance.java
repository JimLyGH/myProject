package com.jimly.kayak.cases.demo1009;


/**
 * 父类Parent中的tellName和printName被重写
 * */
public class Entrance {
	
	public static void main(String[] args) {
		
		new Child();
		
	}

}

/**
 * 运行结果：
 * 
 * 	Child tell:null
	Child print:null
	Child tell:child
	Child print:child
 * */
