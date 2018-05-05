package com.projectzero.dao;

import java.util.List;

import com.projectzero.exceptions.UserNameException;
import com.projectzero.exceptions.UserNotFoundException;

public interface UserDAOInterface {
	public User getUser(String userName) throws UserNotFoundException;
	public List<User> getAllUsers();
	public boolean addUser(String userName, String passwordHash) throws UserNameException;
	public boolean updateUser(int primaryKey, String userName, String passwordHash);
	public boolean deleteUser(int primaryKey);
}
