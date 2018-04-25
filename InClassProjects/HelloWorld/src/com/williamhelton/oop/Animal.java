package com.williamhelton.oop;

public abstract class Animal {
	
	public static String latinName = "animalis";
	private String name;
	
	public Animal() {
		super();
	}
	
	public Animal(String name) {
		this();
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	abstract String makeNoise();
	
}
