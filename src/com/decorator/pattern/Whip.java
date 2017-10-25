package com.decorator.pattern;

public class Whip extends CondimentDecorator {
	Beverage beverage ;
	
	public Whip(Beverage bev){
		this.beverage=bev;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+ " Whip!";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.10+ beverage.cost();
	}

}
