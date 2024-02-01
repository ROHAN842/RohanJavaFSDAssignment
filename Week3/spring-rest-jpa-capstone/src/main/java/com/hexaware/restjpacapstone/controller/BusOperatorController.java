package com.hexaware.restjpacapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.restjpacapstone.entity.BusOperator;
import com.hexaware.restjpacapstone.service.IBusOperatorService;

@RestController
@RequestMapping("/api/busoperator")
public class BusOperatorController {

	@Autowired
	IBusOperatorService service;
	
	@PostMapping("/add")
	public BusOperator insertBusRoute(@RequestBody BusOperator bop)
	{
		return service.addBusRoute(bop);
	}
	
	@PutMapping("/update/{operatorId}")
	public BusOperator updateBusRoute(@PathVariable int operatorId,@RequestBody BusOperator bop)
	{
        bop.setOperatorID(operatorId); // Set the operatorId received from the path variable
		return service.updateBusRoute(bop);
	}
	
	@GetMapping("/get/{operatorId}")
	public BusOperator getBusOperatorById(@PathVariable int operatorId)
	{
		return service.getBusOperatorById(operatorId);
	}
	
	@DeleteMapping("/deleteById/{operatorId}")
	public String deleteBusOperatorById(@PathVariable int operatorId)
	{
		return service.deleteBusOperatorById(operatorId);
	}
	
	@GetMapping("/getall")
	public List<BusOperator> getAll()
	{
		return service.getAllBusRoutes();
	}
	
	// Below one is example of custom query
	@GetMapping("/getbyenamestartwithA")
	public List<BusOperator> getByEnameStartwithA(String operator)
	{
		return service.getNameStartWithA(operator);
	}
	
	// Below one is example of custom query with DML delete query, where we are deleting data be operator name
	@DeleteMapping("/deleteByName/{operatorname}")
	public int deleteBusOperatorByName(@PathVariable String operatorname)
	{
		return service.deleteBusOperatorByName(operatorname);
	}
	

}

