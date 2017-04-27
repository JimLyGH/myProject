package com.jimly.kayak.thread.demo3;

/**
 * 通过实现Runnable接口来实现线程间的资源共享
 * */
public class MutliThreadDemo_C {

	public static void main(String[] args) {

		MutliThread_C m = new MutliThread_C();
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		Thread t3 = new Thread(m);
		t1.start();
		t2.start();
		t3.start();

	}

}

class MutliThread_C implements Runnable {
	private int ticket = 10;// 每个线程都拥有10张票

	public void run() {
		while (ticket > 0) {
			System.out.println(ticket-- + " is saled by "
					+ Thread.currentThread());
		}
	}
}
