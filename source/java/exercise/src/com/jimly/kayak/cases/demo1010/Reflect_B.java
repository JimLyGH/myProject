package com.jimly.kayak.cases.demo1010;

import java.lang.reflect.Method;


/**
 * 通过反射调用方法
 * */
public class Reflect_B {

	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception {
        
		Stu stu = new Stu("zhangsan", 21);
        
        Class c = stu.getClass();
        
        //getMethod()方法需要传入方法名和方法所带参数的参数类型
        Method method = c.getMethod("score", int.class);
        
        //invoke()表示调用的意思,需要传入对象和参数
        method.invoke(stu, 100);
        
        Method m = c.getMethod("say", String.class);
        //这里的null表示不由对象调用,也就是静态方法,把null换位stu也是可行的
        m.invoke(null, "hello java!!!");
    }
	
}


class Stu {
    
    private String name;
    
    private int age;
    
    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void score(int score) {
        System.out.println(this.name + " 考了 " + score + " 分");
    }
    
    public static void say(String str) {
        System.out.println("刚才我说了:" + str);
    }
    
    @Override
    public String toString() {
        return this.name + "-" + this.age;
    }
}
