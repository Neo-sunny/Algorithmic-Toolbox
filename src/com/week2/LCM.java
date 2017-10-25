package com.week2;

import java.math.BigInteger;
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  private static BigInteger lcm_Eff(int a, int b) {
	  long rem=0,big=0,small_hcf=0;
	  if(a>b){big=a;small_hcf=b;}
	  else{small_hcf=a;big=b;}
	  rem=big%small_hcf;
	  while(rem!=0){
		  big=small_hcf;
		  small_hcf=rem;
		  rem=big%small_hcf;
	  }
	  BigInteger a1=new BigInteger(String.valueOf(a));
	  BigInteger b1=new BigInteger(String.valueOf(b));
	  BigInteger hcf=new BigInteger(String.valueOf(small_hcf));
	  BigInteger val= a1.multiply(b1);
	  BigInteger lcm= BigInteger.ZERO;
	  lcm=val.divide(hcf);
	  return lcm;
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(Long.MAX_VALUE);
//    System.out.println(lcm_naive(a, b));
    System.out.println(lcm_Eff(a, b));
  }
}
