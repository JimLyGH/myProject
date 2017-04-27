package com.jimly.kayak.thread.demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * 使用AtomicStampedReference解决CAS(compareAndSwap)操作中存在的ABA问题
 * Join方法的使用参见：JoinTest
 * */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ABA {
	private static AtomicInteger atomicInt = new AtomicInteger(100);
	private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(
			100, 0);

	public static void main(String[] args) throws InterruptedException {
		Thread intT1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				atomicInt.compareAndSet(100, 101);
				atomicInt.compareAndSet(101, 100);
			}
		});

		Thread intT2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}
				System.out.println(2);
				boolean c3 = atomicInt.compareAndSet(100, 101);
				System.out.println(c3); // true
			}
		});

		intT1.start();
		intT2.start();
		intT1.join();
		intT2.join();

		System.out.println("#######################################");
		
		Thread refT1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}
				System.out.println(3);
				atomicStampedRef.compareAndSet(100, 101,
						atomicStampedRef.getStamp(),
						atomicStampedRef.getStamp() + 1);
				atomicStampedRef.compareAndSet(101, 100,
						atomicStampedRef.getStamp(),
						atomicStampedRef.getStamp() + 1);
			}
		});

		Thread refT2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int stamp = atomicStampedRef.getStamp();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
				}
				System.out.println(4);
				boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp,
						stamp + 1);
				System.out.println(c3); // false
			}
		});

		refT1.start();
		refT2.start();
	}
}


/**
 * 运行结果：
 * 
 * 	1
	2
	true
	#######################################
	3
	4
	false
 * */
