package com.BikkadIT.dao;

import java.util.List;

import com.BikkadIT.entity.User;

public interface UserDaoI {
	
	public int saveUserToDb(User user);
	
	public List<User> getAllData();
	
	public List<User> getAllDataFromDB();
	
	public User getSingle(int uid);
	
	public List<User> updateUser(User user);
	
	public List<User> deleteUserById(int id);
	
	
	

}
