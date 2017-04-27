package com.jimly.kayak.thread.demo3;


/**
 * 通过继承Thread类
 * */
public class MutliThreadDemo_A {

	public static void main(String[] args) {

		MutliThread_A m1 = new MutliThread_A("Window 1");
		MutliThread_A m2 = new MutliThread_A("Window 2");
		MutliThread_A m3 = new MutliThread_A("Window 3");

		m1.start();
		m2.start();
		m3.start();
	}

}

class MutliThread_A extends Thread {
	private int ticket = 100;// 每个线程都拥有100张票

	public MutliThread_A() {
	}

	public MutliThread_A(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (ticket > 0) {
			System.out.println(ticket-- + " is saled by "
					+ Thread.currentThread().getName());
		}
	}
}
