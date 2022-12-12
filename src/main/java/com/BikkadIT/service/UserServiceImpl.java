package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.UserDaoI;
import com.BikkadIT.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDaoI userdaoi;

	public int saveUser(User user) {
		System.out.println("Service layer method");
		int id = userdaoi.saveUserToDb(user);
		System.out.println(user);
		return id;
	}

	@Override
	public boolean loginCheckServiceLayer(User user) {
		
		List<User>allData=userdaoi.getAllData();
		
		for(User userDB:allData) {
			
			if(user.getUname().equals(userDB.getUname())&& user.getPassword().
					equals(userDB.getPassword())) {
				return true;
				
			}
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		List<User> list = userdaoi.getAllDataFromDB();
		return list;
	}

	@Override
	public User getSingleUser(int uid) {
		User single =userdaoi.getSingle(uid);
		return single;
	}

	@Override
	public List<User> updateUser(User user) {
	 List<User> updateUser=userdaoi.updateUser(user);
		return updateUser;
	}

	@Override
	public List<User> deleteUser(int id) {
		List<User> list=userdaoi.deleteUserById(id);
		return list;
	}

	

}
