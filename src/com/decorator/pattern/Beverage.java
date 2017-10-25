package com.decorator.pattern;

public abstract class Beverage {

	String description="unknown Beverage";
	public enum size {
	    SMALL,
	    MEDIUM,
	    LARGE;
	}
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
