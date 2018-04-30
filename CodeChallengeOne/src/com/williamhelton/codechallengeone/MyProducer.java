package com.williamhelton.codechallengeone;

public class MyProducer extends Thread {
	
	@Override
	public synchronized void run(){
		int i = 0;
		while(true) {
			if(CodeChallengeOneDriver.pileOfStuff.size() < 10) {
				for(int count = 0; count < Math.random() * (10 - CodeChallengeOneDriver.pileOfStuff.size()); count++) {
					CodeChallengeOneDriver.pileOfStuff.add(i);
					System.out.println("adding " + i++);
				}
			}
			
			try {
				Thread.sleep((long) (Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
