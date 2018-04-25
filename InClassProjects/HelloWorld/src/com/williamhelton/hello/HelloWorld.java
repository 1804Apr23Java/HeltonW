package com.williamhelton.hello;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		Orange o = new Orange();
		o.setColor("purple");
		System.out.println("Orange o is color " + o.getColor());
		
		o.setVariety("valencia");
		System.out.println("Orange o is variety " + o.getVariety());
		
		//What about Object class?
		Object obj = new Object();
		System.out.println(obj.toString()); //returns address in memory as str repr
		// plus "fully qualified classname"
		
		System.out.println(o.toString());
		
		//equals and hashCode
		Fruit f1 = new Fruit("red");
		Fruit f2 = new Fruit("green");
		Fruit f3 = new Fruit("green");
		
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
		System.out.println(f3.hashCode());
		System.out.println(f1.equals(f2));
		System.out.println(f2.equals(f3));
		System.out.println(f2.toString().equals(f3.toString()));
	}

	
	
}
