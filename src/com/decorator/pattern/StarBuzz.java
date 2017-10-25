package com.decorator.pattern;

public class StarBuzz {

	public static void main(String[] args) {
		//Espresso with no condiments
		Beverage bevarege= new Espresso();
		System.out.println(bevarege.getDescription()+"  $" +bevarege.cost());
		
		//DarkRoast with double mocha nad whip
		Beverage bevarege1= new DarkRoast();
		bevarege1=new Mocha(bevarege1);
		bevarege1=new Mocha(bevarege1);
		bevarege1=new Whip(bevarege1);
		System.out.println(bevarege1.getDescription()+"  $" +bevarege1.cost());
	}
}
