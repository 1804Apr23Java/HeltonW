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
}
