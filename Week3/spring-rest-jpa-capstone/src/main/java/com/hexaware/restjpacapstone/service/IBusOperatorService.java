package com.hexaware.restjpacapstone.service;

import java.util.List;

import com.hexaware.restjpacapstone.dto.BusOperatorDTO;
import com.hexaware.restjpacapstone.entity.BusOperator;

public interface IBusOperatorService {
    // Adds a new bus route
    public BusOperator addBusRoute(BusOperatorDTO busRouteDTO);

    // Updates an existing bus route
    public BusOperator updateBusRoute(int operatorId, BusOperatorDTO busRouteDTO);
    
    //Get BusRoute by id
	public BusOperatorDTO getBusOperatorById(int operatorId);

    // Get all BusRoutes
	public List<BusOperator> getAllBusRoutes();

	// deletes by operatorId
	public String deleteBusOperatorById(int operatorId);
	
	// Get all bus operator whose name starts with A
	public List<BusOperator> getNameStartWithA(String operatorname);

	// Deletes bus operator by name
	public int deleteBusOperatorByName(String operatorname);
   

}

