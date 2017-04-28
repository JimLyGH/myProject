package com.jimly.kayak.nio.demo101;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @desc 写文件过程
 * @author jimly
 * @date 2017.04.27
 * */
public class WriteFile {

	public static void main(String[] args) throws IOException {

		byte[] message = { 'h', 'e', 'l', 'l', 'o', ',', 'j', 'a', 'v', 'a',
				'!' };

		// 第一步,从FileOutputStream获取一个通道
		FileOutputStream fos = new FileOutputStream("e://write.txt");
		FileChannel ofc = fos.getChannel();

		//第二步,创建一个缓冲区,并在其中放入一些数据
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		for (int i = 0; i < message.length; i++) {
			buffer.put(message[i]);
		}
		buffer.flip();	//让缓冲区可以将新读入的数据写入另一个通道

		//第三步,写入缓冲区
		ofc.write(buffer);

	}

}
