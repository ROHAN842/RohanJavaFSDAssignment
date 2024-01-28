package com.hexaware.springjdbc_user_capstone.service;

import java.util.List;

import com.hexaware.springjdbc_user_capstone.pojo.User;

public interface IUserService {
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	
	public boolean deleteUserByName(String username);
	public User selectUserByName(String username);
	
	public List<User> selectAllUsers();
 
}
