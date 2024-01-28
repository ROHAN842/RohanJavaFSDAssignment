package com.hexaware.hibernatemapping.services;

import com.hexaware.hibernatemapping.entity.User;
import com.hexaware.hibernatemapping.entity.BusOperator;
import com.hexaware.hibernatemapping.entity.Booking;
import com.hexaware.hibernatemapping.entity.BusRoute;

import java.util.List;

public interface IAdminService {
    // Deletes a user account
    boolean deleteUserAccount(int userId);

    // Deletes a bus operator account
    boolean deleteBusOperatorAccount(int operatorId);

    // Manages booked tickets by the user
    boolean manageBookedTickets(int userId);

    // Views all bus routes
    List<BusRoute> viewAllBusRoutes();
}
