package com.week2;

import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }
  private static long gcd_Eff(int a, int b) {
	  long rem=0,big=0,small=0;
	  if(a>b){big=a;small=b;}
	  else{small=a;big=b;}
	  rem=big%small;
	  while(rem!=0){
		  big=small;
		  small=rem;
		  rem=big%small;
	  }
	  return small;
	  }

		 
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

 //   System.out.println(gcd_naive(a, b));
    System.out.println(gcd_Eff(a, b));
  }
}
