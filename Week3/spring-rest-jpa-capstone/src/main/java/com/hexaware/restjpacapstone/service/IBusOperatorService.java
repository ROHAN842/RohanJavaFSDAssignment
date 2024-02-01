package com.hexaware.restjpacapstone.service;

import java.util.List;

import com.hexaware.restjpacapstone.entity.BusOperator;

public interface IBusOperatorService {
    // Adds a new bus route
    public BusOperator addBusRoute(BusOperator busRoute);

    // Updates an existing bus route
    public BusOperator updateBusRoute(BusOperator busRoute);
    
    //Get BusRoute by id
	public BusOperator getBusOperatorById(int operatorId);

    // Get all BusRoutes
	public List<BusOperator> getAllBusRoutes();

	// deletes by operatorId
	public String deleteBusOperatorById(int operatorId);
	
	// Get all bus operator whose name starts with A
	public List<BusOperator> getNameStartWithA(String operatorname);

	// Deletes bus operator by name
	public int deleteBusOperatorByName(String operatorname);
   

}

