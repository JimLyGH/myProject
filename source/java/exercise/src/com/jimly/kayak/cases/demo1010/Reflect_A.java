package com.jimly.kayak.cases.demo1010;

import java.lang.reflect.Field;

/**
 * 通过反射修改属性
 * */
public class Reflect_A {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		//动态加载类Student
		Class cla = Class.forName("com.jimly.kayak.cases.demo1010.Student");
		
		//实例化Student对象
		Student student = (Student) cla.newInstance();
		
		Field[] fields = student.getClass().getDeclaredFields();
		
		for (Field f : fields) {
			f.setAccessible(true);	//设置是否允许访问，不写运行会报错
			
			if (f.getName() == "name") {
				f.set(student, "zhangsan");
			} else if (f.getName() == "age") {
				f.set(student, 21);
			}
		}

		System.out.println(student);
		
		student.study();
	}
	
}

class Student {
	private String name;
	private int age;
	
	static {
		System.out.println("I am a student!!!");
	}
	
	public Student() { }
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void study() {
		System.out.println("I am " + name + ", " + age + ", I am learning.");
	}
	
	@Override
	public String toString() {
		return "name:" + name + ", age:" + age;
	}
	
}

