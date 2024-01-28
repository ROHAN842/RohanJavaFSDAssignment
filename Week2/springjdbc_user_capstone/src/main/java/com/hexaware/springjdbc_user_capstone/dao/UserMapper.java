package com.hexaware.springjdbc_user_capstone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hexaware.springjdbc_user_capstone.pojo.User;

@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("userID"),rs.getString("username"), rs.getString("password"), rs.getString("email"),
                rs.getString("firstName"), rs.getString("lastName"), rs.getString("phoneNumber"),
                rs.getString("address"), rs.getTimestamp("registrationDate").toLocalDateTime());
    }
} 
