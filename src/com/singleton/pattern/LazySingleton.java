package com.singleton.pattern;

public class LazySingleton {

	private static volatile LazySingleton Instance = null;
	static {
		System.out.println("Inside Static block");
		System.out.println(Instance);
		System.out.println("Exiting  Static block");
	}
	private LazySingleton(){}
	
	public static LazySingleton getInstance(){
		if(Instance == null){
			synchronized(LazySingleton.class){
				Instance = new LazySingleton();
			}
		}
		
		return Instance;
	}
}
