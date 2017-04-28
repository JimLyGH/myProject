package com.jimly.kayak.nio.demo101;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @desc 读文件过程
 * @author jimly
 * @date 2017.04.27
 * */
public class ReadFile {

	public static void main(String[] args) throws IOException {

		// 第一步,从FileInputStream获取一个通道
		FileInputStream fis = new FileInputStream("e://work.txt");
		FileChannel ifc = fis.getChannel();

		// 第二步,创建缓冲区,开辟一个长度为1024字节的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 第三步,将数据从通道读取到缓冲区
		ifc.read(buffer);
		
		System.out.println(new String(buffer.array()));

	}

}
