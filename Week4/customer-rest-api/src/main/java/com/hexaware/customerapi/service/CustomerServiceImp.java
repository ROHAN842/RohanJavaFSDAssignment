package com.hexaware.customerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.dto.Product;
import com.hexaware.customerapi.entity.Customer;
import com.hexaware.customerapi.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setDateofBirth(customerDTO.getDateofBirth());
		customer.setProductId(customerDTO.getProductId());
		
		return repo.save(customer);
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Customer customer = repo.findById(customerId).orElse(null);
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setCustomerName(customer.getCustomerName());
		dto.setDateofBirth(customer.getDateofBirth());
		dto.setProductId(customer.getProductId());
		
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	  @Override
	  public CustomerProductVO getCustomerAndProductById(int customerId)
	  {
	  
	  //step1
		  CustomerDTO customer = getCustomerById(customerId);
		  
		  	int pid =	customer.getProductId();
	  
	  // step2 call rest api from product microservice int pid =customer.getProductId();
	  //Product // http://localhost:8282/api/products/get/{pid}
		  
	// Here below we are using microservices by using products rest api call inside customerDTO method	  
	Product product = restTemplate.getForObject("http://localhost:8282/api/products/get/"+pid, Product.class);
		  
			CustomerProductVO customerProductVO = new CustomerProductVO();
			
			customerProductVO.setCustomer(customer);
			customerProductVO.setProduct(product);
	
	
	  return customerProductVO;
			  
	  }

	@Override
	public String deleteCustomerById(int customerId) {
		repo.deleteById(customerId);
        return "Customer with ID " + customerId + " deleted successfully.";
		
	}
	
	 @Override
	    public String deleteCustomersByProductId(int productId) {
	 
	        List<Customer> customersToDelete = repo.findByProductId(productId);
	        repo.deleteAll(customersToDelete);
	        return "Product with ID " + productId + " deleted successfully from Customer_Info";

	    }
	 
	 
	 @Override
	    public String updateCustomerByCustomerId(int customerId, CustomerDTO customerDTO) {
	        Customer existingCustomer = repo.findById(customerId).orElse(null);
	        if (existingCustomer != null) {
	            // Update the existing customer with the provided details
	            existingCustomer.setCustomerName(customerDTO.getCustomerName());
	            existingCustomer.setDateofBirth(customerDTO.getDateofBirth());
	            existingCustomer.setProductId(customerDTO.getProductId());
	            // Set other fields as needed
	            repo.save(existingCustomer);
	            return "Customer with ID " + customerId + " updated successfully.";
	        } else {
	            return "Customer with ID " + customerId + " not found.";
	        }
	    }

	    @Override
	    public String updateCustomersByProductId(int productId, CustomerDTO customerDTO) {
	        List<Customer> customersToUpdate = repo.findByProductId(productId);
	        if (!customersToUpdate.isEmpty()) {
	            // Update each customer with the provided details
	            for (Customer customer : customersToUpdate) {
	                customer.setCustomerName(customerDTO.getCustomerName());
	                customer.setDateofBirth(customerDTO.getDateofBirth());
	                // Set other fields as needed
	            }	
	            repo.saveAll(customersToUpdate);
	            return "Customers with Product ID " + productId + " updated successfully.";
	        } else {
	            return "No customers found with Product ID " + productId + ".";
	        }
	    }

}