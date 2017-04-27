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

		FileInputStream fic = new FileInputStream("f://work.txt");
		FileChannel ifc = fic.getChannel();
		
		FileOutputStream foc = new FileOutputStream("f://copy.txt");
		FileChannel ofc = foc.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(24);
		
		while (true) {
			
			buffer.clear();	//重设缓冲区,使之可以接受读入的数据
			
			int r = ifc.read(buffer);
			
			buffer.flip();	//让缓冲区可以将新读入的数据写入到另一个通道
			
			ofc.write(buffer);

			if (r == -1) 
				break;
			
		}
		
		
	}
	
	
}
