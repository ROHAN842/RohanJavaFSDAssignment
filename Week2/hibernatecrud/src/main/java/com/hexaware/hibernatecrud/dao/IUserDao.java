package com.hexaware.hibernatecrud.dao;

import java.util.List;

import com.hexaware.hibernatecrud.entity.User;

public interface IUserDao {

    public boolean insertUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUserById(int userID);

    public User selectUserByName(String userName);

    public List<User> selectAllUsers();
}


