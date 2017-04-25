package com.jimly.kayak.junit;

import org.junit.Test;

public class Junit001 {
	
	@Test
	public void junit01() {
		System.out.println("########## JUnit_001_1  ##########");
		float[] a = new float[10];
		System.out.println("float:" + a[0]);
		
		double[] b = new double[10];
		System.out.println("double:" + b[0]);
		
		int[] c = new int[10];
		System.out.println("int:" + c[0]);
		
		long[] d = new long[10];
		System.out.println("long:" + d[0]);
		
		String[] e = new String[10];
		System.out.println("String:" + e[0]);
	}
	
	/**
	 * 输出结果：
	 * 	########## JUnit_001_1  ##########
		float:0.0
		double:0.0
		int:0
		long:0
		String:null
	 * */
	
	@Test
	public void junit02() {
		System.out.println("########## JUnit_001_2  ##########");
		
		Double i = Double.NaN;
		Double j = Double.NaN;
		boolean flag1 = i > j || i <= j;
		System.out.println("flag1=" + flag1);
		
		Float m = Float.NaN;
		Float n = Float.NaN;
		boolean flag2 = m > n || m <= n;
		System.out.println("flag2=" + flag2);
		
		Integer k = Integer.MAX_VALUE;
		boolean flag3 = k + 1 > k;
		System.out.println("flag3=" + flag3);
	}
	
	/**
	 * 输出结果：
	 * 	########## JUnit_001_2  ##########
		flag1=false
		flag2=false
		flag3=false
	 * */

}
