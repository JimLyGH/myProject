package com.jimly.kayak.cases.demo8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Java关键字transient的应用案例
 * 被transient修饰的属性或字段,在序列化时会被序列化
 * */
public class Entrance {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("########## Serializable ##########");
		
		UserInfo userInfo = new UserInfo("张三", "123456");
		
		System.out.println("userinfo序列化前");
		System.out.println(userInfo.toString());
		
		//序列化,被设置为transient的属性不会被序列化
		ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("UserInfo.out"));
		os.writeObject(userInfo);
		os.flush();
		os.close();
		
		//重新读取内容
		ObjectInputStream is = new ObjectInputStream(
				new FileInputStream("UserInfo.out"));
		UserInfo readUserInfo = (UserInfo) is.readObject();
		
		System.out.println("userinfo序列化后");
		System.out.println(readUserInfo.toString());
//		System.out.println(readUserInfo);
		
		
		System.out.println("########## Externalizable ##########");	
	
		ExternalizableTest externalizableTest = new ExternalizableTest();
		
		System.out.println("content序列化前");
		System.out.println(externalizableTest);
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("content.out"));
		out.writeObject(externalizableTest);

		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("content.out"));
		
		externalizableTest = (ExternalizableTest) in.readObject();
		
		System.out.println("content序列化后");
		System.out.println(externalizableTest);
		
		out.close();
		in.close();
		
	}
	
}


/**
 * 运行结果：
 * 	########## Serializable ##########
	userinfo序列化前
	username=张三 passwd=123456
	userinfo序列化后
	username=张三 passwd=null
	########## Externalizable ##########
	content序列化前
	我被transient修饰了,我也会被序列化
	content序列化后
	我被transient修饰了,我也会被序列化
 * */
