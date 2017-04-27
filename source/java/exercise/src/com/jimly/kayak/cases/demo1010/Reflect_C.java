package com.jimly.kayak.cases.demo1010;

import java.lang.reflect.Array;

/**
 * 通过反射操作数组
 * */
public class Reflect_C {

public static void main(String[] args) throws Exception {
        
        int[] arr = {1, 2, 3, 4, 5};
        
        //getComponentType()返回你数组里面装的数据的数据类型的类名称。这里也就是int
        Class<?> c = arr.getClass().getComponentType();    
        
        System.out.println("数组类型:" + c.getName());    //数组类型:int
        
        int len = Array.getLength(arr);
        System.out.println("数组长度:" + len);    //数组长度:5
        
        System.out.print("遍历数组:");
        
        for (int i = 0; i < len; i++) {
            System.out.print(Array.get(arr, i) + " ");    //遍历数组:1 2 3 4 5 
        }
        
        System.out.println();
        
        System.out.println("修改第三个数据前:" + Array.get(arr, 2));    //修改第三个数据前:3
        Array.set(arr, 2, 10);
        System.out.println("修改第三个数据后:" + Array.get(arr, 2));    //修改第三个数据后:10
    }
	
}
