package com.singleton.pattern;

public class EagerSingleton {

	private static volatile EagerSingleton Instance = new EagerSingleton();
	static {
		System.out.println("Inside Static block");
		System.out.println(Instance);
		System.out.println("Exiting  Static block");
	}
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance(){
		return Instance;
	}
}
