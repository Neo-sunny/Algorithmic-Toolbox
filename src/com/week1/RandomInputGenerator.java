package com.week1;

public class RandomInputGenerator {
	static int size;
public static void main(String[] args) {
	 size=getLength();
	getElements();
}

public static int getLength(){
	int minimum=1, maximum=10000;	
	 double randomNum = minimum + (int)(Math.random() * maximum); 
	System.out.println((int)randomNum);
	return (int)randomNum;
	
}
public static void getElements(){
	int minimum=1, maximum=100;	
	for(int i=0;i<size; i++){
	double randomNum = minimum + (int)(Math.random() * maximum); 
	System.out.print((int)randomNum+" ");
}
}
}
