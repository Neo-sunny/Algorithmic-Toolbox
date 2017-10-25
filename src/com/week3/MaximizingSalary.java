package com.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximizingSalary {

	private static String largestNumber(String[] a) {
        //write your code here
		List<Integer> nums= new ArrayList(); 
		for(String s:a){
			nums.add(Integer.parseInt(s));
		}
		Arrays.sort(a);
		Collections.sort(nums);
	//	String[] b=(String[]) nums.toArray();
        String result = "";
       /*for (int i = 0; i < b.length; i++) {
            result += a[i];
        }*/ 
        for(int j=nums.size()-1; j>=0; j--){
        	 result += nums.get(j);
        }
        return result;
    }
	public boolean IsGreaterOrEqual(int digit,int maxDigit){
		
		return true;
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
