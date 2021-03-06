package com.williamhelton.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.williamhelton.media.Movie;

/*
 * This does not work
 * I do not know why
 */

public class SerializeDemo {
	public static void main(String[] args) {
		
		String filename = "src/serializedThings/Movies";
		
		List<Movie> movieList = new ArrayList<Movie>();
		Movie m1 = new Movie("Elie Wies", "Night", 1960, "memoir");
		Movie m2 = new Movie("Ben Carson", "Gifted Hands", 2009, "autobiography");
		Movie m3 = new Movie("Steven Spielberg", "JAWS", 1975, "horror");
		Movie m4 = new Movie("David Latt", "Sharknado", 2013, "science fiction");
		
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		
		System.out.println("Movies before sort: ");
		for (Movie m : movieList) {
			System.out.println(m);
		}
		
		serializeObject(filename, movieList);
		System.out.println(deserializeObject(filename));
	}
	
	public static void serializeObject(String filename, Object o) {
		
		try {
			//use a FileOutputStream to write bytestream to a file
			FileOutputStream fileOut = new FileOutputStream(filename);
		
			//use a ObjectOutputStream to represent an object as a bytestream
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			//actually serialize the object
			out.writeObject(o);
			
			//close streams
			out.close();
			fileOut.close();
			System.out.println("serialization complete");
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object deserializeObject(String filename) {
		Object o = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			o = in.readObject();
			
			in.close();
			fileIn.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
}
