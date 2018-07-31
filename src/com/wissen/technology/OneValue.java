package com.wissen.technology;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneValue {
	static  Reader  reader;
	public static void main(String[] args) throws IOException {
		reader = new Reader();
		int totQ = reader.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<totQ; i++){
			Map<Integer, Integer> m = new HashMap<Integer,Integer>();
			
		
		String[] query = reader.readLine().split("\\s+");
		if(query.length == 1){
			int value = Integer.parseInt(query[0]);
			if(value == 3 && list.size()==0){
				System.out.println("-1");
			}else if(value == 3 && list.size()>0){
				// Integer with least frequency
			}else if (value == 4 && list.size()==0){
				System.out.println("-1");
			}else if(value == 4 && list.size()>0){
				// Integer with highest frequency
			}
		}else if(query.length == 2){
			Integer val1 = Integer.parseInt(query[0]);
			Integer val2 = Integer.parseInt(query[1]);
			
			if(val1 == 1){
				list.add(val2);
				System.out.println(list);
			}else if(val1 == 2 ){
				if(list.contains(val2)){
					list.remove(val2);
					System.out.println(list);
				}
			}
		}
		}
	}
	
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public char nextChar() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
 
            return (char) c;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }	
}

