package com.jimly.kayak.nio.demo101;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @desc 文件拷贝案例
 * @author jimly
 * @date 2017.04.27
 * */
public class Read_Write {

	public static void main(String[] args) throws IOException {

		FileInputStream fic = new FileInputStream("e://work.txt");
		FileChannel ifc = fic.getChannel();
		
		FileOutputStream foc = new FileOutputStream("e://copy.txt");
		FileChannel ofc = foc.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(24);
		
		while (true) {
			
			buffer.clear();	// 重设缓冲区,使之可以接受读入的数据
			
			// 从输入通道中将数据读到缓冲区 
			int r = ifc.read(buffer);
			
			// read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
			if (r == -1) 
				break;
			
			// 让缓冲区可以将新读入的数据写入到另一个通道
			buffer.flip();	
			
			// 从输出通道中将数据写入缓冲区
			ofc.write(buffer);
		}
		
		
	}
	
	
}
