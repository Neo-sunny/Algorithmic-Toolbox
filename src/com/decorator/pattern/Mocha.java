package com.decorator.pattern;

public class Mocha extends CondimentDecorator {
	Beverage beverage ;
	
	public Mocha(Beverage bev){
		this.beverage=bev;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+ " Mocha!";
	}

	@Override
	public double cost() {
		return 0.20+ beverage.cost();
	}

}
