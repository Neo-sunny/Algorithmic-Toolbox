package com.week2;

import java.math.BigInteger;
import java.text.DateFormat;

public class FastDoublingMethod {
//	F(2n) = F(n)[2*F(n+1) – F(n)]
//	F(2n + 1) = F(n)*F(n) + F(n+1)*F(n+1)
	
	public static void getNthFib(int n){
		BigInteger previous = BigInteger.ZERO;  // F(n)
		BigInteger current = BigInteger.ONE;    // F(n+1)
		BigInteger two = new BigInteger("2");  
		BigInteger c= current.multiply(two).subtract(previous); //2*F(n+1) – F(n)
	
		//	for(int bit=Integer.highestOneBit(i)) {}
		
		
	}
	public static void main(String[] args) {
		System.out.println(Integer.highestOneBit(4));
		
	}
}
