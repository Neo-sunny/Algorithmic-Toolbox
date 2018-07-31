package com.algo.sorts;

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] arr = {7,4,5,2};
		sort(arr);
	}
	
	public static void sort(Integer[] arr){
		
		for(int i =0; i<arr.length; i++){
			
			int temp = arr[i];
			int j=i;
			
			while(j>0 && arr[j-1]>temp){
				arr[j] = arr[j-1];
				j= j-1;
			}
			arr[j] = temp;
		}
		
		for(Integer i:arr){
			System.out.print(i+" ");
		}
	}
}
