package com.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NthFibonacci {

  private static long calc_fib(int n) {
	  int previous = 0;
      int current  = 1;

      for (int i = 0; i < n - 1; ++i) {
          int tmp_previous = previous;
          previous = current;
          current = (tmp_previous + current);
      }
    return current;
  }
  private static Map<Integer, Integer> fibCache = new HashMap<>();
  public static int cachedFibN(int n) { if (n < 0) {
  throw new IllegalArgumentException(
  "n must not be less than zero");
  }
  fibCache.put(0, 0); fibCache.put(1, 1);
  return recursiveCachedFibN(n);
  }
  private static int recursiveCachedFibN(int n) { if (fibCache.containsKey(n)) {
  return fibCache.get(n); }
  int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2); fibCache.put(n, value);
  return value;
  }
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
  long startTime=System.nanoTime();
    System.out.println(calc_fib(n));
    long endTime=System.nanoTime();
    long totalTime=endTime- startTime;
    System.out.println("Time difference "+ totalTime);
    
    long startTime1=System.nanoTime();
    System.out.println(cachedFibN(n));
    long endTime1=System.nanoTime();
    long totalTime1=endTime1- startTime1;
    System.out.println("Time difference "+ totalTime1);
  }
}
