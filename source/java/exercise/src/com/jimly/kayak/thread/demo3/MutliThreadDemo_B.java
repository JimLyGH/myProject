package com.jimly.kayak.thread.demo3;


/**
 * 通过实现Runnable接口
 * */
public class MutliThreadDemo_B {

	public static void main(String[] args) {

		MutliThread_B m1 = new MutliThread_B("Window 1");
		MutliThread_B m2 = new MutliThread_B("Window 2");
		MutliThread_B m3 = new MutliThread_B("Window 3");

		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);

		t1.start();
		t2.start();
		t3.start();

	}

}

class MutliThread_B implements Runnable {

	private int ticket = 100;// 每个线程都拥有100张票
	private String name;

	MutliThread_B(String name) {
		this.name = name;
	}

	public void run() {
		while (ticket > 0) {
			System.out.println(ticket-- + " is saled by " + name);
		}
	}
}
