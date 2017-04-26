package com.jimly.kayak.thread.demo2;

/**
 * join() 方法是让调用该方法的主线程执行run()时暂时卡住,等run()执行完成后,主线程再调用执行join()后面的代码
 * t.join()方法阻塞调用此方法的线程(calling thread),直到线程t完成,此线程再继续
 * */
class ThreadA implements Runnable {

	private int counter;

	@Override
	public void run() {
		while (counter <= 10) {
			System.out.print("Thread_A = " + counter + " ");
			counter++;
		}
		System.out.println();
	}
}

class ThreadB implements Runnable {

	private int i;

	@Override
	public void run() {
		while (i <= 10) {
			System.out.print("Thread_B = " + i + " ");
			i++;
		}
		System.out.println();
	}
}

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadA());
		Thread t2 = new Thread(new ThreadB());
		t1.start();
		t1.join();
		t2.start();
		t2.join();

		for (int i = 0; i < 10; i++) {
			System.out.print("I am Main ");
		}
	}

}
