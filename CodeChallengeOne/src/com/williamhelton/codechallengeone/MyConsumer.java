package com.williamhelton.codechallengeone;

public class MyConsumer extends Thread {

	@Override
	public void run(){
		while(true) {
			int numberToRemove = (int) (Math.random() * (CodeChallengeOneDriver.pileOfStuff.size()));
			for(int i = 0; i < numberToRemove; i++) {
				System.out.println("removed " + CodeChallengeOneDriver.pileOfStuff.remove(0));
			}
			
			try {
				Thread.sleep((long) (Math.random() * 50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
