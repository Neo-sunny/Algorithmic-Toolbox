package com.week3;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	int change=0;
    	/*Denominations are 1, 5 ,10
    	 * 1) if m<1 return Invalid
    	 * 2)if m>1 & m<5 use denomination 1
    	 * 3)if m>5 && m< 10 use denominations 5 and  1
    	 * 4) if m>10 use all denominations
    	 * */
    	if(m<1)
    		return 0;
    	else if(m>=1 && m<5){
    		change=m/1;
    	}else if(m>=5 && m<10){
    		int c1=m/5;
    		int left=m%5;
    		change=c1+left;
    	}else if(m>=10){
    		int c1=m/10;
    		int c2=(m%10)/5;
    		int c3=(m%10)%5;
    		change=c1+c2+c3;
    	}
        return change;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

