package com.jimly.kayak.exam;

public class E_Thread {
	
	public static void main(String[] args) {
		
		Thread t = new Thread() {
			public void run() {
				System.out.println("pong");
			};
		};
		
//		t.run();	//pong在ping之前输出
		t.start();	//pong输出位置不确定(多次执行才有效果)
		
		System.out.println("ping1");
		System.out.println("ping2");
		System.out.println("ping3");
		System.out.println("ping4");
		System.out.println("ping5");
		System.out.println("ping6");
		System.out.println("ping7");
		
	}

}
