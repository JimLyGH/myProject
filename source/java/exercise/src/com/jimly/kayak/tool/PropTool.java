package com.jimly.kayak.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropTool {
	
	final static String file = "src/prop.properties";
	
	public static void main(String[] args) throws IOException {
		
		getProperties();
		
//		System.out.println(getValByKey("username"));
		
//		writeProp("text", "UE");
		
	}

	
	//往***.properties文件中新增字段
	public static void writeProp(String insertKey, String insertVal) throws IOException {
		Properties pps = new Properties();
		InputStream is = new FileInputStream(file);
		pps.load(is);	//从输入流中读取属性列表
		
		OutputStream os = new FileOutputStream(file);
		pps.setProperty(insertKey, insertVal);
		
		//store和save方法一样,save底层调用的还是store方法,只不过多了一个线程安全机制
//		pps.save(os, "Insert " + insertKey + " name");
		pps.store(os, "Insert " + insertKey + " name");
	}
	
	
	
	//根据key值获取value值,properties中没有对应的key则返回NULL
	public static String getValByKey(String key) throws IOException {
		Properties pps = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		pps.load(is);
		
		String val = pps.getProperty(key, "NULL");
		
		return val;
	}
	
	

	//读取***.properties配置文件信息
	@SuppressWarnings("rawtypes")
	public static void getProperties() throws IOException {
		Properties pps = new Properties();
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		pps.load(is);
		//得到配置文件名字
		Enumeration en = pps.propertyNames();
		
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			System.out.println(key + " = " + pps.getProperty(key));
		}
	}
}


