package com.jimly.kayak.cases.demo1011;

public class Entrance {

	public static void main(String[] args) {
		
		ArgsVariable variable = new ArgsVariable();

		
		System.out.println("---------------------------------------");
		variable.StrVariable();
		variable.StrVariable("abc");
		variable.StrVariable("abc", "def");
		
		System.out.println("---------------------------------------");
		variable.intVariable();
		variable.intVariable(123);
		variable.intVariable(123, 456, 789);
		
		System.out.println("---------------------------------------");
		variable.floVariable();
		variable.floVariable(1.1f, 1.2f);
		variable.floVariable(1.0f, 1.1f, 1.2f);
		
		System.out.println("---------------------------------------");
		variable.integerVariable();
		variable.integerVariable(1);
		variable.integerVariable(1, 2, 3, 4, 5);
		
		System.out.println("---------------------------------------");
		variable.ObjVariable();
		variable.ObjVariable(1, "abc", 1.1f);
		variable.ObjVariable("abc", "def", 1.0, 1.1f, 2);
		
	}
	
}
