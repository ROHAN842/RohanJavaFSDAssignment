package com.hexaware.restjpacapstone.dto;

import java.sql.Date;

public class BusOperatorDTO {
	
	private int operatorID;
    private String operatorUsername;
    private String operatorPassword;
    private String operatorName;
    private String email;
    private String phoneNumber;
    private Date registrationDate;
    
    
	public BusOperatorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BusOperatorDTO(int operatorID, String operatorUsername, String operatorPassword, String operatorName,
			String email, String phoneNumber, Date registrationDate) {
		super();
		this.operatorID = operatorID;
		this.operatorUsername = operatorUsername;
		this.operatorPassword = operatorPassword;
		this.operatorName = operatorName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}


	public int getOperatorID() {
		return operatorID;
	}


	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}


	public String getOperatorUsername() {
		return operatorUsername;
	}


	public void setOperatorUsername(String operatorUsername) {
		this.operatorUsername = operatorUsername;
	}


	public String getOperatorPassword() {
		return operatorPassword;
	}


	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}


	public String getOperatorName() {
		return operatorName;
	}


	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


	@Override
	public String toString() {
		return "BusOperatorDTO [operatorID=" + operatorID + ", operatorUsername=" + operatorUsername
				+ ", operatorPassword=" + operatorPassword + ", operatorName=" + operatorName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", registrationDate=" + registrationDate + "]";
	}
	
	
	

    
}
