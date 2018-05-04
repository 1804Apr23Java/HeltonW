package com.williamhelton.codechallengeone;

import java.util.ArrayList;
import java.util.List;

public class CodeChallengeOneDriver {
	
	public static List<Integer> pileOfStuff = new ArrayList<>();
	public static int freeSpace = 0;
	
	public static void main(String[] args) {
		MyProducer producer = new MyProducer();
		MyConsumer consumer = new MyConsumer();
		
		producer.start();
		producer.setName("producer");
		consumer.start();
		consumer.setName("consumer");
		
		while(true) {
			freeSpace = 10-pileOfStuff.size();
			
			if(freeSpace == 0) {
				try {
					MyConsumer.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			if(freeSpace == 9) {
				try {
					MyProducer.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		}
	}
}