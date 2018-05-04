package com.projectzer.dao;

public interface UserDAOInterface {
	public User getUser(int primaryKey);
	public boolean addUser(String passwordHash);
	public boolean updateUser(String passwordHash);
	public boolean deleteUser(int primaryKey);
}
