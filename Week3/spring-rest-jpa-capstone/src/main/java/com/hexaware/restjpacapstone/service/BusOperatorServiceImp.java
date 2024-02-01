package com.hexaware.restjpacapstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.restjpacapstone.entity.BusOperator;
import com.hexaware.restjpacapstone.repository.BusOperatorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusOperatorServiceImp implements IBusOperatorService {

	@Autowired
	BusOperatorRepository busop;
	@Override
	public BusOperator addBusRoute(BusOperator busRoute) {
		// TODO Auto-generated method stub
		return busop.save(busRoute);
	}

//	@Override
//	public BusOperator updateBusRoute(BusOperator busRoute) {
//		// TODO Auto-generated method stub
//		return busop.save(busRoute);
//	}
	
	@Override
    public BusOperator updateBusRoute(BusOperator updatedBusOperator) {
        // Fetch the existing entity by its ID
        int operatorId = updatedBusOperator.getOperatorID();
        BusOperator existingBusOperator = busop.findById(operatorId).orElse(null);
        
        if (existingBusOperator != null) {
            // Update the fields of the existing entity with new values
            existingBusOperator.setOperatorUsername(updatedBusOperator.getOperatorUsername());
            existingBusOperator.setOperatorPassword(updatedBusOperator.getOperatorPassword());
            existingBusOperator.setOperatorName(updatedBusOperator.getOperatorName());
            existingBusOperator.setEmail(updatedBusOperator.getEmail());
            existingBusOperator.setPhoneNumber(updatedBusOperator.getPhoneNumber());
            existingBusOperator.setRegistrationDate(updatedBusOperator.getRegistrationDate());
            
            // Save the updated entity back to the database
            return busop.save(existingBusOperator);
        } else {
            // If the entity with the given ID doesn't exist, return null or throw an exception
            return null; // or throw new EntityNotFoundException("Bus Operator with ID " + operatorId + " not found");
        }
    }


	@Override
	public List<BusOperator> getAllBusRoutes() {
		// TODO Auto-generated method stub
		return busop.findAll();
	}

	@Override
	public String deleteBusOperatorById(int operatorId) {
		// TODO Auto-generated method stub
		busop.deleteById(operatorId);
		return "Record Deleted";
	}

	@Override
	public BusOperator getBusOperatorById(int operatorId) {
		// TODO Auto-generated method stub
		return busop.findById(operatorId).orElse(null);
	}
	
	@Override
	public List<BusOperator> getNameStartWithA(String operatorname) {
		// TODO Auto-generated method stub
		return busop.getNameStartWithA(operatorname);
	}

	@Override 
	public int deleteBusOperatorByName(String operatorname) {
		// TODO Auto-generated method stub
		return busop.deleteBusOperatorByName(operatorname);
	}

}
