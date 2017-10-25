package com.decorator.pattern;

public class DarkRoast extends Beverage{

	public DarkRoast(){
		description="Dark Roast coffee";
	}
	
	@Override
	public double cost() {
		return .99;
	}

}
