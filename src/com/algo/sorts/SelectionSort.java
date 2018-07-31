package com.algo.sorts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp1 = br.readLine().split("\\s+");
		String[] inp2 = br.readLine().split("\\s+");
		Integer[] arr = new Integer[inp2.length];
		int index=0;
		for(String s:inp2){
			arr[index++] = Integer.parseInt(s);
		}
		sortArray(arr,  Integer.parseInt(inp1[1]));
	}
	
	static void sortArray(Integer[] arr, int x){
		for(int i=0; i<x; i++){
			int min = i;
			
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<arr[min]){
					min =j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		for(Integer i: arr){
		    System.out.print(i+" ");
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
}
