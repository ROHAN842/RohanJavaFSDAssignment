package com.hexaware.customerapi.restcontroller;

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

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.entity.Customer;
import com.hexaware.customerapi.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

	@Autowired
	ICustomerService service;

	@PostMapping(value="/add",consumes = "application/xml" , produces = "application/json")
	public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {

		return service.addCustomer(customerDTO);
	}

	@GetMapping(value="/get/{customerId}" , produces = "application/xml")
	public CustomerDTO getCustomerById(@PathVariable int customerId) {

		return service.getCustomerById(customerId);

	}

	@GetMapping("/getall")
	public List<Customer> getAllCustomer() {

		return service.getAllCustomer();

	}

	@GetMapping("/get/customer-product/{customerId}")
	public CustomerProductVO getCustomerAndProductById(@PathVariable int customerId) {

		return service.getCustomerAndProductById(customerId);

	}

    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomerById(@PathVariable int customerId) {
        return service.deleteCustomerById(customerId);
    }
	
	@DeleteMapping("/deleteByProductId/{productId}")
    public String deleteCustomersByProductId(@PathVariable int productId) {
        return service.deleteCustomersByProductId(productId);
    }
	
	
	@PutMapping("/update/{customerId}")
    public String updateCustomerByCustomerId(@PathVariable int customerId, @RequestBody CustomerDTO customerDTO) {
        return service.updateCustomerByCustomerId(customerId, customerDTO);
    }

    @PutMapping("/updateByProductId/{productId}")
    public String updateCustomersByProductId(@PathVariable int productId, @RequestBody CustomerDTO customerDTO) {
        return service.updateCustomersByProductId(productId, customerDTO);
    }
}
