package com.hexaware.customerapi.service;

import java.util.List;

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.entity.Customer;

public interface ICustomerService {

	public Customer	addCustomer(CustomerDTO customerDTO);
	public CustomerDTO	getCustomerById(int customerId);
	public List<Customer>	getAllCustomer();
	public   CustomerProductVO   getCustomerAndProductById(int customerId);
    public String deleteCustomerById(int customerId);
	public String deleteCustomersByProductId(int productId);
    public String updateCustomerByCustomerId(int customerId, CustomerDTO customerDTO);
    public String updateCustomersByProductId(int productId, CustomerDTO customerDTO);

}
