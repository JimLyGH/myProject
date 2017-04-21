package com.jimly.kayak.exam;

/**
 * 根据里氏代换原则：任何基类(父类)可以出现的地方,子类一定可以出现
 * */
public class E_Exception {

	public static void main(String[] args) throws Exception {
		
		try {
			throw new EB();
		} catch (EA a) {
			System.out.println("EA");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
		
		System.out.println("########################");
		
		try {

			try {
				throw new EB();
			} catch (EA a) {
				System.out.println("EA");
				throw a;
			}

		} catch (EB b) {
			System.out.println("EB");
			return;
		} finally {
			System.out.println("hello");
		}
		
	}

}

@SuppressWarnings("serial")
class EA extends Exception {
}

@SuppressWarnings("serial")
class EB extends EA {
}



/**
 * 程序输出结果：
 * 	EA
	########################
	EA
	EB
	hello
 * */
