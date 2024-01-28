package com.hexaware.springjdbc_user_capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springjdbc_user_capstone.dao.IUserDao;
import com.hexaware.springjdbc_user_capstone.pojo.User;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    IUserDao dao;

    @Override
    public boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }
 
    @Override
    public boolean deleteUserByName(String username) {
        return dao.deleteUserByName(username);
    }
 
    @Override
    public User selectUserByName(String username) {
        return dao.selectUserByName(username);
    } 

    @Override
    public List<User> selectAllUsers() {
        return dao.selectAllUsers();
    }
}
