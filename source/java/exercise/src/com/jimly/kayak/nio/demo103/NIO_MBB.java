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
		
		String inputFile = "e://work.txt";
		String outputFile = "e://out.txt";
		
		RandomAccessFile inf = new RandomAccessFile(inputFile, "r");
		RandomAccessFile outf = new RandomAccessFile(outputFile, "rw");

		int length = (int) new File(inputFile).length();
		
		FileChannel ifc = inf.getChannel();
		FileChannel ofc = outf.getChannel();
		
		MappedByteBuffer buffer = ifc.map(FileChannel.MapMode.READ_ONLY, 0, length);
		
		Charset latin1 = Charset.forName("ISO-8859-1");
		CharsetDecoder decoder = latin1.newDecoder();
		CharsetEncoder encoder = latin1.newEncoder();
		
		CharBuffer cBuffer = decoder.decode(buffer);
		
		ByteBuffer outputData = encoder.encode(cBuffer);
		
		ofc.write(outputData);
		
		inf.close();
		outf.close();
	}

}
