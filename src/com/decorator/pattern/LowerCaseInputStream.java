package com.decorator.pattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException{
		int c= super.read();
		
		return (c== -1 ? c: Character.toLowerCase((char)c)); 
	}
	public int read(byte[] b, int offset, int length) throws IOException{
		int result =super.read(b, offset, length);
		for(int i=offset; i<offset+result;i++){
			b[i]= (byte) Character.toLowerCase((char)b[i]);
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		int c;
		InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/Users/Neo/Desktop/test.txt")));
			while( (c = in.read()) >=0){
				System.out.print((char)c);
			}
	
	
	}
}
