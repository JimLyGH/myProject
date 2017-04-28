package com.jimly.kayak.nio.demo103;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NIO_MBB {
	
	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		
		String inputFile = "e://work.txt";
		String outputFile = "e://out.txt";
		
		RandomAccessFile inf = new RandomAccessFile(inputFile, "r");
		RandomAccessFile outf = new RandomAccessFile(outputFile, "rw");

		int length = (int) new File(inputFile).length();
		
		FileChannel ifc = inf.getChannel();
		FileChannel ofc = outf.getChannel();
		
		MappedByteBuffer buffer = ifc.map(FileChannel.MapMode.READ_ONLY, 0, length);
		
		// 创建 UTF-8 字符集的一个实例
		Charset latin1 = Charset.forName("UTF-8");
		// 创建一个解码器(用于读取)
		CharsetDecoder decoder = latin1.newDecoder();
		// 创建一个编码器 (用于写入)
		CharsetEncoder encoder = latin1.newEncoder();
		
		// 将字节数据解码为一组字符
		CharBuffer cBuffer = decoder.decode(buffer);
		
		// 如果想要处理字符，我们可以在程序的此处进行
		//……
//		System.out.println(cBuffer);
		
		// 无改变地将它写回
		ByteBuffer outputData = encoder.encode(cBuffer);
		
//		System.out.println(new String(outputData.array()));
		
		// 将数据写到文件中
		ofc.write(outputData);
		
		long end = System.currentTimeMillis();
		
		System.out.println("读取" + (length / 1024 / 1024) + "M文件用时" + (end - start) / 1000 + "s");
		
		inf.close();
		outf.close();
	}

}
