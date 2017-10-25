package com.week1;

public class Child extends parent{
	public void display() {
		System.out.println("child ");
	}
	
	public static void main(String[] args) {
		parent p1= new Child();
		p1.display();
	}
}
class parent{
	
	public void display() {
		System.out.println("Parent ");
	}
}
