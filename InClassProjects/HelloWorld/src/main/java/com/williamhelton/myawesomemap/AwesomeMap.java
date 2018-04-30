/*
 * TRIPLE PAIR PROGRAMMING
 * by William, JJ and Collin
 */

package main.java.com.williamhelton.myawesomemap;

public class AwesomeMap {
	
	String[] keyArray = new String[0];
	String[] valueArray = new String[0];

	public String remove(String key) {
		for (int i = 0; i < keyArray.length; i++) {
			
			if (keyArray[i] != null && keyArray[i].equals(key)) {
				
				String[] tempKeyArray = new String[keyArray.length-1];
				String[] tempValueArray = new String[valueArray.length-1];
				
				String val = valueArray[i]; 
				
				
				
				if(i==0 && keyArray.length > 1) {
					System.out.println("if");
					System.arraycopy(keyArray, 1, tempKeyArray, 0, keyArray.length-1);
					System.arraycopy(valueArray, 1, tempValueArray, 0, keyArray.length-1);
				}
				
				else if(i==keyArray.length-1) {
					// where we placed 0s
					System.out.println("else if");
					System.arraycopy(keyArray, 0, tempKeyArray, 0, keyArray.length - 1);
					System.arraycopy(valueArray, 0, tempValueArray, 0, valueArray.length - 1);
				}
				else {
					System.out.println("else");
					System.arraycopy(keyArray, 0, tempKeyArray, 0, i);
					System.arraycopy(valueArray, 0, tempValueArray, 0, i);
					System.arraycopy(keyArray, i+1, tempKeyArray, i, keyArray.length - i - 1);
					System.arraycopy(valueArray, i+1, tempValueArray, i, valueArray.length - i - 1);
				}
				
				keyArray = tempKeyArray;
				valueArray = tempValueArray;
				
				return val;
				
			}
		}
		return null;
	}

	public boolean add(String key, String val) {
		
		for (int i = 0; i < keyArray.length; i++) {
			
			if (keyArray[i] != null && keyArray[i].equals(key)) {
				
				valueArray[i] = val;
				return true;
			}
		}
		
		String[] tempKeyArray = new String[keyArray.length+1];
		String[] tempValueArray = new String[valueArray.length+1];
		
		System.arraycopy(keyArray, 0, tempKeyArray, 0, keyArray.length);
		System.arraycopy(valueArray, 0, tempValueArray, 0, valueArray.length);
		
		tempKeyArray[tempKeyArray.length-1] = key;
		tempValueArray[tempValueArray.length-1] = val;
		
		keyArray = tempKeyArray;
		valueArray = tempValueArray;
		
		return false;
	}

	public boolean contains(String key) {
		
		for (String s : keyArray) {
			
			if (s.equals(key)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public String get(String key) {
		for (int i = 0; i < keyArray.length; i++) {
			
			if (keyArray[i].equals(key)) {
				
				return valueArray[i];
			}
		}
		
		return null;
	}
}
