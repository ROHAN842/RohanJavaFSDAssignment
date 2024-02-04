package com.hexaware.restjpacapstone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.restjpacapstone.dto.BusOperatorDTO;
import com.hexaware.restjpacapstone.entity.BusOperator;
import com.hexaware.restjpacapstone.service.IBusOperatorService;
import com.hexaware.restjpacapstone.exception.BusOperatorNotFoundException;

@RestController
@RequestMapping("/api/busoperator")
public class BusOperatorController {

	@Autowired
	IBusOperatorService service;
	Logger  logger =	LoggerFactory.getLogger(BusOperatorController.class);

	@PostMapping("/add")
	public BusOperator insertBusRoute(@RequestBody BusOperatorDTO bop)
	{
		logger.info("EmployeeRestController executed...");
		return service.addBusRoute(bop);
	}
	
	@PutMapping("/update/{operatorId}")
	public BusOperator updateBusRoute(@PathVariable int operatorId,@RequestBody BusOperatorDTO bop)
	{
		logger.info("EmployeeRestController UpdateMethod executed...");
        bop.setOperatorID(operatorId); // Set the operatorId received from the path variable
		return service.updateBusRoute(operatorId,bop);
	}
	
//	@GetMapping("/get/{operatorId}")
//	public BusOperatorDTO getBusOperatorById(@PathVariable int operatorId)
//	{
//		logger.info("EmployeeRestController getBusOperatorById executed...");
//		return service.getBusOperatorById(operatorId);
//	}
	
	@GetMapping("/get/{operatorId}")
	public BusOperatorDTO getBusOperatorById(@PathVariable int operatorId) {
	    logger.info("EmployeeRestController getBusOperatorById executed...");
	    BusOperatorDTO busOperatorDTO = service.getBusOperatorById(operatorId);
	    if (busOperatorDTO == null) {
	        throw new BusOperatorNotFoundException(HttpStatus.BAD_REQUEST, "Bus Operator Not Found for Operator ID: " + operatorId);
	    }
	    return busOperatorDTO;
	}
	
	@DeleteMapping("/deleteById/{operatorId}")
	public String deleteBusOperatorById(@PathVariable int operatorId)
	{
		logger.info("EmployeeRestController deleteBusOperatorById Method executed...");
		return service.deleteBusOperatorById(operatorId);
	}
	
	@GetMapping("/getall")
	public List<BusOperator> getAll()
	{
		logger.info("EmployeeRestController getAll() executed...");
		return service.getAllBusRoutes();
	}
	
	// Below one is example of custom query
	@GetMapping("/getbyenamestartwithA")
	public List<BusOperator> getByEnameStartwithA(String operator)
	{
		logger.info("EmployeeRestController for fetching names starting with 'A' executed...");
		return service.getNameStartWithA(operator);
	}
	
	// Below one is example of custom query with DML delete query, where we are deleting data be operator name
	@DeleteMapping("/deleteByName/{operatorname}")
	public int deleteBusOperatorByName(@PathVariable String operatorname)
	{
		logger.info("EmployeeRestController deletOperatorByname executed...");
		return service.deleteBusOperatorByName(operatorname);
	}
	

}

