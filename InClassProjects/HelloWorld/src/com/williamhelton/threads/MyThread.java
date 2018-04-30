package com.williamhelton.threads;

public class MyThread extends Thread {
	
	
	@Override
	public void run() {
		System.out.println("Hello from " + this.getName());
		
		for(int i = 0; i < 1000; i++) {
			Counter.incrementCount();
			System.out.println(this.getName() + " incremented count for iter i " + i);
			System.out.println(Counter.getCount());
		}
	}
	
}
