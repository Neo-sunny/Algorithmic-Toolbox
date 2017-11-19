package com.credit.suisse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


public class NiceQueries {
	static BufferedReader br;
    static Reader reader;
	public static void main(String[] args) throws NumberFormatException, IOException {
		reader = new Reader();
		//BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		//String[] vals= br.readLine().split("\\s+");
		int N=reader.nextInt();
		int Q=reader.nextInt();
		long[] arr= new long[N];		
		for(int i=0; i<Q; i++){
			//String[] queries= br.readLine().split("\\s+");
			 int v1=reader.nextInt();
			 int v2=reader.nextInt();
			 if(v1 ==1){
				 arr[v2-1]=-1;
			 }else if(v1 ==2){
				int res= Arrays.binarySearch(arr, v2-1, N-1, -1);
				if(res>0)
					System.out.println(res+1);
				else
					System.out.println(-1);
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
