package com.algo.sorts;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int lastAnswer=0;
        Scanner in = new Scanner(System.in);
        int sizeOfSeq = in.nextInt();
        int n=10;
        List<Long> lst=new LinkedList<>();
        for(int i=0; i<=n+1; i++) {
        	lst.add((long) 0);
        }
        int[][] seqs= new int[sizeOfSeq][sizeOfSeq];
        System.out.println(Arrays.deepToString(seqs));
        int queries = in.nextInt();
        int seqIndex;
       
// loop for number of queries  
        for(int i=0; i<queries; i++){
        	 int q =  in.nextInt();
        if(q==1){
            int x=in.nextInt();
            int y=in.nextInt();
            seqIndex= ((x^lastAnswer)%sizeOfSeq);
            if(seqs[seqIndex][0]==0){
                seqs[seqIndex][0]=y;
            }else{
            	int j=0;
               for(; j<sizeOfSeq;j++){
            	   if(seqs[seqIndex][j]==0){break;}
               }
                seqs[seqIndex][j]=y;
            }
        }
        else if(q==2){
            int x=in.nextInt();
            int y=in.nextInt();
            seqIndex= ((x^lastAnswer)%sizeOfSeq);
            int j=0;
            for(; j<sizeOfSeq;j++){
         	   if(seqs[seqIndex][j]==0){break;}
            }
            int idx=y%j;
            lastAnswer=seqs[seqIndex][idx];
            System.out.print(lastAnswer);
        }
    }
        
    }
}