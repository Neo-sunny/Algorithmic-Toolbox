package com.credit.suisse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoGroups {
	
	static int M= 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int tCase=Integer.parseInt(br.readLine());

		
		for(int i=0; i<tCase; i++){
			int N=Integer.parseInt(br.readLine());
			int n=N-1;
			long val=findPowerN(2,n);
			System.out.println(2*(val-1));
		}
	}
	static long findPowerN(long number, int power){
	    long res = 1;
	    long sq = number;
	    while(power > 0){
	        if(power % 2 == 1){
	            res *= sq; 
	        }
	        sq = sq%M * sq%M;
	        power /= 2;
	    }
	    return res;
	}
	
}
