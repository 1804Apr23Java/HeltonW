package com.williamhelton.hello;

public class Orange extends Fruit {
	
	private String variety;

	// no args constructor
	public Orange() {
		super(); //calls Fruit no args constructor
	}
	
	public Orange(String variety) {
		this(); //implicitly inserted even if we leave it out
		this.variety = variety;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}	
	
	
	//overriding - providing a new implementation of an instance method in a subclass
	//need to have same method signature as superclass' method
	//@Override annotation doesn't actually do anything
	@Override
	public String toString() {
		return "Orange [variety=" + variety + "]";
	}
	
	//code blocks
	
	//instance:
	{
		System.out.println("This is an instance code block and will run when this class is instantiated.");
		//runs before the constructor
	}
	
	//static:
	static {
		System.out.println("This is a static code block and will run once when this class passes through the JVM");
		//runs when it became necessary to access this class
	}
	
}
