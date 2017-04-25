package com.jimly.kayak.thread.demo1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * newScheduledThreadPool
 * 	创建一个定长线程池,支持定时及周期性任务执行
 * */
public class ScheduledThread {

	public static void main(String[] args) {
		
		delayMtthod();
		
		regularMethod();
	}
	
	
	//延迟执行代码,程序延迟5秒执行
	public static void delayMtthod() {
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		scheduledThreadPool.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("delay 5 seconds execute!!!");
			}
		}, 5, TimeUnit.SECONDS);
		
	}
	
	//定期执行代码,程序延迟1秒后每5秒执行一次
	static public void regularMethod() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("delay 1 seconds, and execute every 5 seconds!!!");
			}
		}, 1, 5, TimeUnit.SECONDS);
		
	} 
	
}
