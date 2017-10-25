package com.week2;

import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
        }

        return current ;
    }
    private static  BigInteger getFibonacciLastDigitEfficient(int n){
    	BigInteger previous = BigInteger.ZERO;
		BigInteger current = BigInteger.ONE;
		 for (int i = 0; i < n; ++i) {
			 BigInteger  tmp_previous=previous;
			 previous = current;
			 current=tmp_previous.add(current);
		 }
		 System.out.println(current);
    	return current.mod(BigInteger.TEN);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
//        System.out.println(getFibonacciLastDigitEfficient(n));
        System.out.println(c);
    }
}

