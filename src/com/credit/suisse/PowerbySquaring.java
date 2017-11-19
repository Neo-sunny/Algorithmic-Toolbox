package com.credit.suisse;

// A way to find power of number in order of logn

public class PowerbySquaring {

	static long powerN(long number, int power){
	    long res = 1;
	    long sq = number;
	    while(power > 0){
	        if(power % 2 == 1){
	            res *= sq; 
	        }
	        sq = sq * sq;
	        power /= 2;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		System.out.println(powerN(2,5));
	}
}
