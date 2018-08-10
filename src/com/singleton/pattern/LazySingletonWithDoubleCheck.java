package com.singleton.pattern;

public class LazySingletonWithDoubleCheck {

	private static volatile LazySingletonWithDoubleCheck Instance = null;
	static {
		System.out.println("Inside Static block");
		System.out.println(Instance);
		System.out.println("Exiting  Static block");
	}
	
	private LazySingletonWithDoubleCheck(){}
	
	public static LazySingletonWithDoubleCheck getInstance(){
		if(Instance == null){
			synchronized (LazySingletonWithDoubleCheck.class) {
				// double Check
				if(Instance==null){
					Instance = new LazySingletonWithDoubleCheck();
				}
			}
		}
		
		return Instance;
	}
}
