package com.singleton.pattern;

public class BillPughSingleton {

	private BillPughSingleton(){}
	
	private static class LazyInstance{
		
		private static final BillPughSingleton INSTANCE  = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance(){
		return LazyInstance.INSTANCE;
	}
}
