package com.jimly.kayak.thread.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * newFixedThreadPool
 * 	创建一个定长线程池,可控制线程的最大并发数,超过的线程会在队列中等待
 * 	代码中控制的线程池大小为3,每个任务输出index和线程名称后休眠5秒,
 * 	因此每5秒打印三行记录
 * 
 *	附:定长线程池的大小最好根据系统资源进行设置 	
 * */
public class FixedThread {

	public static void main(String[] args) {
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			fixedThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("index=" + index + ", Thread Name:" + Thread.currentThread().getName());

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
	}
	
}
