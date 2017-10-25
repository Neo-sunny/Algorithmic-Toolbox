package com.algo.sorts;

public class QuickSort {

	
	public int[] quicksorting(int arr[], int start, int end){
		
		if(start<end){
			int piv_pos=partition(arr,start,end);
			quicksorting(arr,start,piv_pos-1);
			quicksorting(arr,piv_pos+1,end);
			
		}
		
		return arr;
	}
	
	public int partition(int array[], int start, int end){
		
		int pivot=(start+end)/2;
		// swapping the pivot with last element
		int piv_elm=array[pivot];
		array[pivot]=array[end];
		array[end]=piv_elm;
		int i=start;int j=end-1;
		while(i<=j){
			while(array[i]<piv_elm && i<j)
				i++;
				
			while(array[j]>piv_elm && i<j){
				j--;
			}
				int temp1=array[i];
				array[i]=array[j];
				array[j]=temp1;
				i++;j--;
	}
		int temp2=array[i];
		array[i]=piv_elm;
		array[end]=temp2;
		for(int k:array){
			System.out.print(k+" ");
		}System.out.println();
		return i;
	}
public static void main(String[] args) {
final	int[] arr={8,1,6,9,6,3,5,2,7,0};
	QuickSort sort= new QuickSort();
	int[] arr1=sort.quicksorting(arr, 0, 9);
	
}

}
