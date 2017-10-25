package com.week1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

class APlusB {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    System.out.println(a + b);
   Map<Integer, String> imap= new HashMap<>(); 
   
   for(Map.Entry<Integer,String > ientry: imap.entrySet()) {
	   ientry.getKey();
	   ientry.getKey();
   }
   List<String> myList = new CopyOnWriteArrayList<String>();
  }

}
