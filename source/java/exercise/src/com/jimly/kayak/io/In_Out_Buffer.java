package com.jimly.kayak.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * InputStream与OutputStream采用缓冲区
 * */
public class In_Out_Buffer {

	public static void main(String[] args) {

		String src = "E:/demo6.txt";
		String des = "E:/copy.txt";

		// FileInputStream fIn = null;
		// FileOutputStream fOut = null;

		BufferedInputStream bIs = null;
		BufferedOutputStream bOs = null;

		try {
			/**
			 * fIn = new FileInputStream(src); fOut = new FileOutputStream(des);
			 * 
			 * bIs = new BufferedInputStream(fIn); bOs = new
			 * BufferedOutputStream(fOut);
			 */

			bIs = new BufferedInputStream(new FileInputStream(src));
			bOs = new BufferedOutputStream(new FileOutputStream(des));

			byte[] buffer = new byte[1024];
			int num = 0;

			while ((num = bIs.read(buffer)) != -1) {
				// 用到num不用buffer.length的主要原因:
				// 是由于最后一次循环如果不够buffer数组定义的长度的话,不够的部分会被默认填充0,而用num就不会
				bOs.write(buffer, 0, num);
			}

			bOs.flush(); // 将缓存区的内容写进目的文件

		} catch (IOException e) {
			System.out.println("读写文件时异常:" + e);
		} finally {
			try {
				if (null != bIs)
					bIs.close();

				if (null != bOs)
					bOs.close();

			} catch (IOException e) {
				System.out.println("读写文件时异常:" + e);
			}
		}
	}

}
