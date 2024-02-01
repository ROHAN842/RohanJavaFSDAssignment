package com.hexaware.restjpacapstone.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_operator")
public class BusOperator {
	//This below @GeneratedValue annotation is used for primary key id value if we want to be auto generated
	@Id
	@GeneratedValue
	private int operatorID;
    private String operatorUsername;
    private String operatorPassword;
    private String operatorName;
    private String email;
    private String phoneNumber;
    private Date registrationDate;
    
    public BusOperator() {
    	
    }

	public BusOperator(int operatorID, String operatorUsername, String operatorPassword, String operatorName,
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
		return "BusOperator [operatorID=" + operatorID + ", operatorUsername=" + operatorUsername
				+ ", operatorPassword=" + operatorPassword + ", operatorName=" + operatorName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", registrationDate=" + registrationDate + "]";
	}
    
    
}
