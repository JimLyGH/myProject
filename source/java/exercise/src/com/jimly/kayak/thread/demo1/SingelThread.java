package com.jimly.kayak.thread.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * newSingleThreadExecutor
 * 	创建一个单线程化的线程池,它只会用唯一的工作线程来执行任务,保证所有任务按照指定的顺序执行
 * */
public class SingelThread {

	public static void main(String[] args) {
		
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			singleThreadPool.execute(new Runnable() {
				
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
