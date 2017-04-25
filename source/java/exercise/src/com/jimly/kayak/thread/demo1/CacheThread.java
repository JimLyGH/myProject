package com.jimly.kayak.thread.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * newCachedThreadPool
 * 	创建一个可缓存线程池,如果线程池长度超过处理需要,可灵活回收空闲线程,若无可回收,则新建线程
 * 	线程池容量大小为:Integer.MAX_VALUE
 *	当执行第二个任务时,第一个任务已经完成,会复用执行第一个任务的线程,而不用每次新建线程 
 * */
public class CacheThread {

	public static void main(String[] args) {
		
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			
			try {
				//去掉休眠代码后看运行结果
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			cacheThreadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("index=" + index + ", Thread Name:" + Thread.currentThread().getName());
				}
			});
		}
	}
	
}
