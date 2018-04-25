package com.williamhelton.oop;

public class Cat extends Animal implements Domestic {

	@Override
	String makeNoise() {
		// TODO Auto-generated method stub
		return "meow";
	}

	@Override
	public void pet() {
		// TODO Auto-generated method stub
		System.out.println("petting cat");
	}

}
