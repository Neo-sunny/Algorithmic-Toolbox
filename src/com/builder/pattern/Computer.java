package com.builder.pattern;

public class Computer {

	
	private String HDD;
	String RAM;
	boolean isGraphicsCardEnabled;
	boolean isBlueToothEnabled;
	
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBlueToothEnabled() {
		return isBlueToothEnabled;
	}
	
	private Computer(ComputerBuilder builder){
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isBlueToothEnabled=builder.isBlueToothEnabled;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
	}
	
	public static class ComputerBuilder{
		private String HDD;
		String RAM;
		boolean isGraphicsCardEnabled;
		boolean isBlueToothEnabled;
		
		public ComputerBuilder(String hdd, String ram){
			this.HDD=hdd;
			this.RAM=ram;
		}
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}
		public ComputerBuilder setBlueToothEnabled(boolean isBlueToothEnabled) {
			this.isBlueToothEnabled = isBlueToothEnabled;
			return this;
		}
		public Computer build(){
			return new Computer(this);
		}
		
	}
}
