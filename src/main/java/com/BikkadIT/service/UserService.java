package com.BikkadIT.service;

import java.util.List;

import com.BikkadIT.entity.User;

public interface UserService {
	
	public int saveUser(User user);
	
	public boolean loginCheckServiceLayer(User user);
	
	public List<User> getAll();
	
	public User getSingleUser(int uid);
	
	public List<User> updateUser(User user);
	
	public List<User> deleteUser(int id);
	
	
	

}
