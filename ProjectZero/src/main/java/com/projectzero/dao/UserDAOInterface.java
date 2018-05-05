package com.projectzero.dao;

import java.util.List;

public interface UserDAOInterface {
	public User getUser(String userName);
	public List<User> getAllUsers();
	public boolean addUser(String userName, String passwordHash);
	public boolean updateUser(int primaryKey, String userName, String passwordHash);
	public boolean deleteUser(int primaryKey);
}
