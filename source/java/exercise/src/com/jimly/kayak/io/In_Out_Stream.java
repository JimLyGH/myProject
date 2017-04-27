package com.jimly.kayak.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * InputStream与OutputStream(字节流)
 * */
public class In_Out_Stream {

	public static void main(String[] args) {

		String src = "E:/demo6.txt";
		String des = "E:/copy.txt";

		FileInputStream fIn = null;
		FileOutputStream fOut = null;

		try {
			fIn = new FileInputStream(src);
			fOut = new FileOutputStream(des);

			byte[] buffer = new byte[1024];
			int num = 0; // num的目的用于防止最后一次读取的字节小于buffer长度

			while ((num = fIn.read(buffer)) != -1) {
				// 参数1:写入的字符串;2:从开始写入字符的偏移量;3:要写入的字符数
				System.out.println("共" + num + "个字节");
				fOut.write(buffer, 0, num);
			}

		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (null != fIn)
					fIn.close();

				if (null != fOut)
					fOut.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
