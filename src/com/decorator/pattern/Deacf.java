package com.decorator.pattern;

public class Deacf extends Beverage{

	public Deacf(){
		description="Decaf";
	}
	
	@Override
	public double cost() {
		return 1.05;
	}

}
