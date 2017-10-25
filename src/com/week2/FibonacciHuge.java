package com.week2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/* Task. Given two integers n and m, output Fn mod m 
 * (that is, the remainder of Fn when divided by m).*/

public class FibonacciHuge {
	static FileOutputStream file;
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    private static long getFibonacciHugeEff(long fi, long m){
    	String pattern="";
    	StringBuilder mPattern= new StringBuilder("0");
    	int count=0;
    	boolean flag=true;
    	if (fi <= 1)
            return fi;
    	long previous = 0;
        long current  = 1;
    	while(flag){
    		long tmp_previous = previous;
            previous = current;
            mPattern.append(current%m);
            if(tmp_previous%m==0 && previous%m==1){
            	count++;
            	if(count==2)
            		break;
            }
            
            current = tmp_previous + current;
            
    	}
    	pattern=mPattern.toString().substring(0, mPattern.length()-2);
    	long charPlace=fi%pattern.length();
    	String i=pattern.substring((int)charPlace, (int)charPlace+1);
    	System.out.println("pattern "+pattern+" charPlace "+charPlace);
    	System.out.println("i "+i);
    	return 0;
    }
    public static void main(String[] args) throws FileNotFoundException {
    	file = new FileOutputStream("output.txt");
		System.setOut(new PrintStream(file));
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
      System.out.println(getFibonacciHugeEff(n, m)); 
    }
}

