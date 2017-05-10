package com.jimly.kayak.cases.demo1011;


/**
 * 形参变量可变
 * */
public class ArgsVariable {
	
	public void StrVariable(String ...strings) {
		System.out.println("###############	String Variable	###############");
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");
		}
		System.out.println();
	}
	
	public void intVariable(int ...ints) {
		System.out.println("###############	int Variable	###############");
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}
	
	
	public void floVariable(float ...floats) {
		System.out.println("###############	float Variable	###############");
		for (int i = 0; i < floats.length; i++) {
			System.out.print(floats[i] + " ");
		}
		System.out.println();
	}
	
	
	public void integerVariable(Integer ...integers) {
		System.out.println("###############	Integer Variable	###############");
		for (int i = 0; i < integers.length; i++) {
			System.out.print(integers[i] + " ");
		}
		System.out.println();
	}
	
	public void ObjVariable(Object ...objects) {
		System.out.println("###############	Object Variable	###############");
		for (int i = 0; i < objects.length; i++) {
			System.out.print(objects[i] + " ");
		}
		System.out.println();
	}

}

