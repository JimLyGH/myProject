package com.jimly.kayak.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Reader与Writer采用缓存区(一次读取一行)
 * */
public class R_W_Buffer_A {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		String src = "E:/work.txt";
		String des = "E:/out.txt";

		BufferedReader br = null; // 创建缓冲区读对象引用
		BufferedWriter bw = null; // 创建缓冲区写对象引用

		try {
			br = new BufferedReader(new FileReader(src));
			bw = new BufferedWriter(new FileWriter(des));

			String line = null;

			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}

			bw.flush(); // 将缓冲区的数据写到目的地,用缓存区必须执行此方法

			long end = System.currentTimeMillis();
			
			System.out.println((end - start) / 1000 + " s");
			
		} catch (IOException e) {
			System.out.println("读写时异常:" + e);
		} finally {
			try {
				if (null != br)
					br.close();

				if (null != bw)
					bw.close();

			} catch (IOException e) {
				System.out.println("关闭流时异常:" + e);
			}
		}
	}

}
