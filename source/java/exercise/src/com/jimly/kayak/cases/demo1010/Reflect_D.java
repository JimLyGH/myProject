package com.jimly.kayak.cases.demo1010;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 通过反射调用带参数的构造方法
 * */
public class Reflect_D {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> c = Class.forName("com.jimly.kayak.cases.demo1010.Man");

		Constructor<?> con = c.getConstructor(String.class, int.class);

		Object obj = con.newInstance("1", 12);

		obj.toString();
	}

}


class Man {
	private String name;
	private int age;

	public Man(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		System.out.println(this.name + ":" + this.age);
		return this.name + ":" + this.age;
	}
}