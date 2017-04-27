package com.jimly.kayak.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Reader与Writer(字符流)
 * */
public class R_W {

	public static void main(String[] args) {

		String src = "E:/demo6.txt";
		String des = "E:/copy.txt";

		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader(src);
			fw = new FileWriter(des);

			char[] buffer = new char[1024];

			int num = 0;

			while ((num = fr.read(buffer)) != -1) {
				System.out.println("共" + num + "个字符");
				fw.write(buffer, 0, num);
			}

		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (null != fr)
					fr.close();

				if (null != fw)
					fw.close();

			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}
