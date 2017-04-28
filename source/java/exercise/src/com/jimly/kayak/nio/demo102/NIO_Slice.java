package com.jimly.kayak.nio.demo102;

import java.nio.ByteBuffer;


/**
 * @desc slice() 方法根据现有的缓冲区创建一种 子缓冲区 .
 * 				   也就是说,它创建一个新的缓冲区,新缓冲区与原来的缓冲区的一部分共享数据.
 * 			注意:子缓冲区是与缓冲区中的数据是共享的.
 * @author jimly
 * @date 2017.04.28
 * */
public class NIO_Slice {
	
	public static void main(String[] args) {
		// 开辟一个长度为10字节的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		
		// 使用数据来填充这个缓冲区,在第i个槽放入数字i
		for (int i = 0; i < buffer.capacity(); ++i) {
			buffer.put((byte) i);
		}
		
		// 创建一个槽3到槽6的子缓冲区.
		buffer.position(3);
		buffer.limit(7);
		ByteBuffer slice = buffer.slice();
		
		// 遍历子缓冲区,并对子缓冲区中的数据进行改变
		for (int i = 0; i < slice.capacity(); ++i) {
			byte b = slice.get(i);
			b *= 11;
			slice.put(i, b);
		}
		
		buffer.position(0);
		buffer.limit(buffer.capacity());
		
		// 遍历原缓冲区,查看里面的数据
		while (buffer.remaining() > 0) {
			System.out.print(buffer.get() + " ");
		}
		
	}
	

}
