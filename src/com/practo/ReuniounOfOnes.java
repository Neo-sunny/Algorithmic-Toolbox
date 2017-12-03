package com.practo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReuniounOfOnes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split("\\s+");
		int len = Integer.parseInt(firstLine[0]);
		int queries = Integer.parseInt(firstLine[1]);
		String secondLine = br.readLine();
		
		int[] initArr = getArrayfromString(secondLine);
		for (int q = 0; q < queries; q++) {
			String[] qArr = br.readLine().split("\\s+");
			int q1 = Integer.parseInt(qArr[0]);
			if (q1 == 1) {
				int sublen = 0, maxsubSize = 0, x = 1;
				for (int i : initArr) {
					if (i == x) {
						len++;
						if (maxsubSize < len) {
							maxsubSize = len;
						}
					} else if (i == 0) {
						len = 0;
					}
				}
				System.out.println(maxsubSize);
			} else if (q1 == 2) {
				int q2 = Integer.parseInt(qArr[1]);
				initArr[q2 - 1] = 1;
			}
		}
	}

	static int[] convertToIntArray(String[] arr) {
		return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
	}
	static int[] getArrayfromString(String arr){
		int [] sline = new int[arr.length()];
		int index=0;
		for ( char c: arr.toCharArray()){
			if(c==0){
				sline[index]=(int)c-47;
			}else{
				sline[index]=(int)c-48;
			}
			
			index++;
		}
		return sline;
	}
	

}
