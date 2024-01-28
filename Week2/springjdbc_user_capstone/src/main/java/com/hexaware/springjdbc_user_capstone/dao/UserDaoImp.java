package com.hexaware.springjdbc_user_capstone.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.springjdbc_user_capstone.pojo.User;

@Repository
public class UserDaoImp implements IUserDao {

    JdbcTemplate jdbcTemplate;

    @Autowired    
	public UserDaoImp(DataSource datasource)
	{
		jdbcTemplate = new JdbcTemplate(datasource);
		System.out.println(jdbcTemplate);
	}

    @Override
    public boolean insertUser(User user) {
        String insertQuery = "INSERT INTO User (username, password, email, firstName, lastName, phoneNumber, address, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int count = jdbcTemplate.update(insertQuery, user.getUsername(), user.getPassword(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getAddress(),
                user.getRegistrationDate());
        return count > 0;
    }

   
   // Here below one is the correct way to implement update query as we are updating user data based on username so we are keeping 
   // userName inside where clause as with respect to userName we need to update rest things which are written after set inside below
   // query such as password, email, firstName, lastName, phoneNumber and address
    
    // Below query is if we want to update based on username
    @Override
    public boolean updateUser(User user) {
        String updateQuery = "UPDATE User SET password = ?, email = ?, firstName = ?, lastName = ?, phoneNumber = ?, address = ? WHERE username = ?";
        int count = jdbcTemplate.update(updateQuery, user.getPassword(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getAddress(), user.getUsername());
        return count > 0;
    }

    
    // Below query is if we want to update based on userID

//    @Override
//    public boolean updateUser(User user) {
//        String updateQuery = "UPDATE User SET username = ?, password = ?, email = ?, firstName = ?, lastName = ?, phoneNumber = ?, address = ? WHERE userID = ?";
//        
//        // The jdbcTemplate.update method executes the SQL update query with the provided parameters
//        int count = jdbcTemplate.update(updateQuery, 
//                user.getUsername(), user.getPassword(), user.getEmail(),
//                user.getFirstName(), user.getLastName(), 
//                user.getPhoneNumber(), user.getAddress(), 
//                user.getUserID());
//
//        // Returns true if at least one row was updated, otherwise false
//        return count > 0;
//    }

  


 
    @Override
    public boolean deleteUserByName(String username) {
        String deleteQuery = "DELETE FROM User WHERE username = ?";
        int count = jdbcTemplate.update(deleteQuery, username);
        return count > 0;
    } 

    @Override
    public User selectUserByName(String username) {
        String selectQuery = "SELECT * FROM User WHERE username = ?";
        User user = jdbcTemplate.queryForObject(selectQuery, new UserMapper(), username);
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        String selectAllQuery = "SELECT * FROM User";
        List<User> list = jdbcTemplate.query(selectAllQuery, new UserMapper());
        return list;
        
    }

    }

