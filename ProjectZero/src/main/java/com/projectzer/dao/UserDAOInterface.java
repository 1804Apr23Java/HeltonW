package com.projectzer.dao;

public interface UserDAOInterface {
	public User getUser(int primaryKey);
	public boolean addUser(String userName, String passwordHash);
	public boolean updateUser(int primaryKey, String userName, String passwordHash);
	public boolean deleteUser(int primaryKey);
}
