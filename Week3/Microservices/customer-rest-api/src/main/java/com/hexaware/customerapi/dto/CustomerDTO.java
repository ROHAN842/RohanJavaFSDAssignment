package com.hexaware.customerapi.dto;

import java.time.LocalDate;

public class CustomerDTO {

	private int customerId;
	private String customerName;
	private LocalDate dateofBirth;
	
	private int productId;

	
	
	public CustomerDTO(int customerId, String customerName, LocalDate dateofBirth, int productId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateofBirth = dateofBirth;
		this.productId = productId;
	}

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
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
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", dateofBirth="
				+ dateofBirth + ", productId=" + productId + "]";
	}
	
	
	
	
	
	
}
