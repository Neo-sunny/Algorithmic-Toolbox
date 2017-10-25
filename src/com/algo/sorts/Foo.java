package com.algo.sorts;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    static {
         System.out.println("Message");
         System.exit(0);
    } 
   
    public static void main(String[] args) {
    	 List<Integer> l1= new ArrayList();
    	    List<List<Integer>> l2= new ArrayList();
    	    l1.add(1);
    	    l2.add(l1);
    	    int sizeOfSeq = 2;
            int[][] seqs= new int[sizeOfSeq][];    
            if(seqs[0].length==0){}
	}
}