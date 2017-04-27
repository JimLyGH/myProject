package com.jimly.kayak.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Reader与Writer采用缓存区(一次读取指定长度字符)
 * */
public class R_W_Buffer_B {

	public static void main(String[] args) {

		String src = "E:/demo6.txt";
		String des = "E:/copy.txt";

		FileReader fr = null;
		FileWriter fw = null;

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(src);
			fw = new FileWriter(des);

			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			char[] buffer = new char[512];
			int num = 0;

			while ((num = br.read(buffer)) != -1) {
				bw.write(buffer, 0, num);
			}

			bw.flush();

		} catch (IOException e) {
			System.out.println("读写时异常:" + e);
		} finally {
			try {
				if (null != br)
					fr.close();

				if (null != bw)
					fw.close();

			} catch (IOException e) {
				System.out.println("关闭流时异常:" + e);
			}
		}
	}

}
