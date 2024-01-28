package com.hexaware.hibernatecrud.service;

import java.util.List;

import com.hexaware.hibernatecrud.entity.User;

public interface IUserService {

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUserById(int userID);

    public User selectUserByName(String userName);

    public List<User> selectAllUsers();
}
 