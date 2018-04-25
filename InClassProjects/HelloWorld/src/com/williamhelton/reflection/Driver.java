package com.williamhelton.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.williamhelton.exceptions.MediaException;
import com.williamhelton.media.Book;
import com.williamhelton.media.Media;
import com.williamhelton.media.Movie;
import com.williamhelton.oop.Cat;

public class Driver {

	public static void main(String[] args) {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book("Elie Wies", "Night", 1960, "memoir");
		Book b2 = new Book("Ben Carson", "Gifted Hands", 2009, "autobiography");
		Movie m1 = new Movie("Steven Spielberg", "JAWS", 1975, "horror");
		Movie m2 = new Movie("David Latt", "Sharknado", 2013, "science fiction");
		
		mediaList.add(b1);
		mediaList.add(m2);
		mediaList.add(m1);
		mediaList.add(b2);
		
		//funWithReflections();
		
		//System.out.println(genericReflections(mediaList));
		
		//List<Media> filteredMediaList = objectReflections(mediaList);
		
		System.out.println(filterByMediaType(mediaList, "Book"));
	}
	
	public static List<Media> filterByMediaType(List<Media> mediaList, String mediaType){
		
		List<Media> filteredList = new ArrayList<Media>();
		try {
			checkType(mediaType);
		} catch (MediaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		for (Media item : mediaList) {
			if(item.getClass().getName().equals("com.williamhelton.media."+mediaType)) {
				filteredList.add(item);
			}
		}
		
		return filteredList;
	}
	
	public static void checkType(String type) throws MediaException {
		if(!type.equals("Book") && !type.equals("Movie")) {
			throw new MediaException();
		}
	}

	//return list of Books from mediaList, if exists
	public static <T> List<T> genericReflections(List<T> l) {
		List<T> newList = new ArrayList<T>();
		
		for (T item : l) {
			if(item.getClass().getName().equals("com.williamhelton.media.Book")) {
				newList.add(item);
			}
		}
		return newList;
	}
	
	//what if we had no type safety?
	public static List<Object> objectReflections(List<Object> l){
		List<Object> newList = new ArrayList<Object>();
		
		for (Object item : l) {
			if(item.getClass().getName().equals("com.williamhelton.media.Book")) {
				newList.add(item);
			}
		}
		//off the rails
		newList.add(new Cat());
		return newList;
	}
	
	public static void funWithReflections() {
		
		try {
			//get Book class using reflection
			Class class1 = Class.forName("com.williamhelton.media.Book");
			System.out.println(class1.getSimpleName());
			
			//print declared fields
			Field[] field = class1.getDeclaredFields();
			for (Field f : field) {
				System.out.println(f.getName() + " with a datatype of " + f.getType());
			}
			
			//new instance of book
			//this breaks the shit out of encapsulation
			Book b3 = (Book) class1.newInstance();
			Field author = class1.getDeclaredField("author");
			author.setAccessible(true);
			author.set(b3, "Michael Bay");
			System.out.println(b3);
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
