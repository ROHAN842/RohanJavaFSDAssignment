package com.hexaware.restjpacapstone.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.restjpacapstone.dto.BusOperatorDTO;
import com.hexaware.restjpacapstone.entity.BusOperator;
import com.hexaware.restjpacapstone.exception.BusOperatorNotFoundException;
import com.hexaware.restjpacapstone.repository.BusOperatorRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusOperatorServiceImp implements IBusOperatorService {

    @Autowired
    BusOperatorRepository busop;

	Logger logger = LoggerFactory.getLogger(BusOperatorServiceImp.class);

    
    @Override
    public BusOperator addBusRoute(BusOperatorDTO busRoute) {
		logger.info(busRoute + " is Added from Add Service");

        BusOperator busOperator = new BusOperator();
        busOperator.setOperatorUsername(busRoute.getOperatorUsername());
        busOperator.setOperatorPassword(busRoute.getOperatorPassword());
        busOperator.setOperatorName(busRoute.getOperatorName());
        busOperator.setEmail(busRoute.getEmail());
        busOperator.setPhoneNumber(busRoute.getPhoneNumber());
        busOperator.setRegistrationDate(busRoute.getRegistrationDate());
        return busop.save(busOperator);
    }

    @Override
    public BusOperator updateBusRoute(int operatorId, BusOperatorDTO updatedBusOperator) {

        BusOperator existingBusOperator = busop.findById(operatorId).orElse(null);
		logger.info(existingBusOperator + " is Updated from UpdateBusRoute Service Method");
        if (existingBusOperator != null) {
            existingBusOperator.setOperatorUsername(updatedBusOperator.getOperatorUsername());
            existingBusOperator.setOperatorPassword(updatedBusOperator.getOperatorPassword());
            existingBusOperator.setOperatorName(updatedBusOperator.getOperatorName());
            existingBusOperator.setEmail(updatedBusOperator.getEmail());
            existingBusOperator.setPhoneNumber(updatedBusOperator.getPhoneNumber());
            existingBusOperator.setRegistrationDate(updatedBusOperator.getRegistrationDate());
            return busop.save(existingBusOperator);
        } else {
            // throw new EntityNotFoundException("Bus Operator with ID " + operatorId + " not found");
            throw new BusOperatorNotFoundException(HttpStatus.BAD_REQUEST, "Bus Operator Not Found for Operator ID: " + operatorId);
        }
    }

    @Override
    public List<BusOperator> getAllBusRoutes() {
	    logger.debug("I am debug");
	    logger.info("All Bus Route details fetched successfully!!");
        return busop.findAll();
    }

    @Override
    public String deleteBusOperatorById(int operatorId) {
     
	    try {
	        busop.deleteById(operatorId);
	        logger.warn("Bus Operator with ID " + operatorId + " deleted successfully");
	        return "Bus Operator with ID " + operatorId + " deleted successfully.";
	    } catch (Exception e) {
	        logger.error("Error deleting product with ID " + operatorId + ": " + e.getMessage());
	        return "Error deleting bus operator with ID " + operatorId + ": " + e.getMessage();
	    }
    }

    @Override
    public BusOperatorDTO getBusOperatorById(int operatorId) {
	    logger.info("Bus Operator details with" + operatorId + " fetching in this method !!");
        return busop.findById(operatorId).map(this::convertToDto).orElse(null);
        
        // OR another method is as below 
//        BusOperator b = busop.findById(operatorId).orElse(null);
//        if(b!=null)
//        {
//            BusOperatorDTO dto = new BusOperatorDTO();
//            dto.setOperatorID(b.getOperatorID());
//            dto.setOperatorUsername(b.getOperatorUsername());
//            dto.setOperatorPassword(b.getOperatorPassword());
//            dto.setOperatorName(b.getOperatorName());
//            dto.setEmail(b.getEmail());
//            dto.setPhoneNumber(b.getPhoneNumber());
//            dto.setRegistrationDate(b.getRegistrationDate());
//            return dto; 	
//        }
//        else {
//        	return null;
//        }
        
    }

    @Override
    public List<BusOperator> getNameStartWithA(String operatorname) {
        logger.info("Fetching bus operators whose names start with '{}'", operatorname);
        List<BusOperator> operators = busop.getNameStartWithA(operatorname);
        logger.info("Found {} bus operators whose names start with '{}'", operators.size(), operatorname);
        return operators;
    }

    @Override
    public int deleteBusOperatorByName(String operatorname) {
        logger.warn("Bus Operator with Name " + operatorname + " deleted successfully");
        return busop.deleteBusOperatorByName(operatorname);
    }

    private BusOperatorDTO convertToDto(BusOperator busOperator) {
        BusOperatorDTO dto = new BusOperatorDTO();
        dto.setOperatorID(busOperator.getOperatorID());
        dto.setOperatorUsername(busOperator.getOperatorUsername());
        dto.setOperatorPassword(busOperator.getOperatorPassword());
        dto.setOperatorName(busOperator.getOperatorName());
        dto.setEmail(busOperator.getEmail());
        dto.setPhoneNumber(busOperator.getPhoneNumber());
        dto.setRegistrationDate(busOperator.getRegistrationDate());
        return dto;
    }
}
