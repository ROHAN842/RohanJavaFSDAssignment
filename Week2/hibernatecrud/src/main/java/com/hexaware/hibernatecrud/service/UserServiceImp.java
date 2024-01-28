package com.hexaware.hibernatecrud.service;

import java.util.List;

import com.hexaware.hibernatecrud.dao.IUserDao;
import com.hexaware.hibernatecrud.dao.UserDaoImp;
import com.hexaware.hibernatecrud.entity.User;


public class UserServiceImp implements IUserService {

	IUserDao dao = new UserDaoImp();

    @Override
    public boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public boolean deleteUserById(int userID) {
        return dao.deleteUserById(userID);
    }

    @Override
    public User selectUserByName(String userName) {
        return dao.selectUserByName(userName);
    }

    @Override
    public List<User> selectAllUsers() {
        return dao.selectAllUsers();
    }
}
