package test.java.com.williamhelton.myawesomemap;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.williamhelton.myawesomemap.AwesomeMap;

public class AwesomeMapTest {
	
	@Test
	public void receivesNullWhenRemoveFails() {
		AwesomeMap awesomeMap = new AwesomeMap();
		assertNull(awesomeMap.remove(""));
	}
	
	@Test
	public void addNewKeyToMap() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey", "myValue");
		assertEquals(awesomeMap.contains("myKey"), true);
	}
	
	@Test
	public void removesOnlyKeyFromMap() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey", "myValue");
		awesomeMap.remove("myKey");
		assertEquals(awesomeMap.contains("myKey"), false);
	}
	
	@Test
	public void removesKeyFromMapAtBeginning() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey1", "myValue1");
		awesomeMap.add("myKey2", "myValue2");
		awesomeMap.add("myKey3", "myValue3");
		awesomeMap.remove("myKey1");
		assertEquals(awesomeMap.contains("myKey1"), false);
	}	
	
	@Test
	public void removesKeyFromMapAtMiddle() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey1", "myValue1");
		awesomeMap.add("myKey2", "myValue2");
		awesomeMap.add("myKey3", "myValue3");
		awesomeMap.remove("myKey2");
		assertEquals(awesomeMap.contains("myKey2"), false);
	}
	
	@Test
	public void removesKeyFromMapAtEnd() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey1", "myValue1");
		awesomeMap.add("myKey2", "myValue2");
		awesomeMap.add("myKey3", "myValue3");
		awesomeMap.remove("myKey3");
		assertEquals(awesomeMap.contains("myKey3"), false);
	}
	
	@Test
	public void getsValFromMap() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey1", "myValue1");
		awesomeMap.add("myKey2", "myValue2");
		awesomeMap.add("myKey3", "myValue3");
		assertEquals("myValue2", awesomeMap.get("myKey2"));
	}
	
	@Test
	public void getValFromMapReturnsNullIfKeyNotFound() {
		AwesomeMap awesomeMap = new AwesomeMap();
		awesomeMap.add("myKey1", "myValue1");
		awesomeMap.add("myKey2", "myValue2");
		awesomeMap.add("myKey3", "myValue3");
		assertNull(awesomeMap.get("myKey4"));
	}
}
