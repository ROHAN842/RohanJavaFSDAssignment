package com.hexaware.customerapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_info")
public class Customer {

	@Id
	private int customerId;
	private String customerName;
	private LocalDate dateofBirth;
	
	private int productId;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(int customerId, String customerName, LocalDate dateofBirth, int productId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateofBirth = dateofBirth;
		this.productId = productId;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateofBirth=" + dateofBirth
				+ ", productId=" + productId + "]";
	}
	
	
}
