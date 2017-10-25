package com.decorator.pattern;

public class Soy extends CondimentDecorator {
	Beverage beverage ;
	
	public Soy(Beverage bev){
		this.beverage=bev;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+ " Soy!";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.15+ beverage.cost();
	}

}
