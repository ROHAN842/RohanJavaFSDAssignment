package com.hexaware.hibernatemapping.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BusOperator {
	@Id
	private int operatorId;
	private String operatorUsername;
	private String operatorPassword;
	private String operatorname;
	private String emailId;
	private String phoneNumber;
	private Date registrationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "busOperator")
	private Set<JWTToken> jwtToken = new HashSet<JWTToken>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "busOperator")
	private Set<AuditLog> auditLog = new HashSet<AuditLog>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "busOperator")
	private Set<BusSchedule> busSchedule = new HashSet<BusSchedule>();
	
	public BusOperator() {
		
	}


	public BusOperator(int operatorId, String operatorUsername, String operatorPassword, String operatorname,
			String emailId, String phoneNumber, Date registrationDate, Admin admin, Set<JWTToken> jwtToken,
			Set<AuditLog> auditLog, Set<BusSchedule> busSchedule) {
		super();
		this.operatorId = operatorId;
		this.operatorUsername = operatorUsername;
		this.operatorPassword = operatorPassword;
		this.operatorname = operatorname;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
		this.admin = admin;
		this.jwtToken = jwtToken;
		this.auditLog = auditLog;
		this.busSchedule = busSchedule;
	}


	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
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

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public Set<JWTToken> getJwtToken() {
		return jwtToken;
	}



	public void setJwtToken(Set<JWTToken> jwtToken) {
		this.jwtToken = jwtToken;
	}



	public Set<AuditLog> getAuditLog() {
		return auditLog;
	}



	public void setAuditLog(Set<AuditLog> auditLog) {
		this.auditLog = auditLog;
	}


	public Set<BusSchedule> getBusSchedule() {
		return busSchedule;
	}


	public void setBusSchedule(Set<BusSchedule> busSchedule) {
		this.busSchedule = busSchedule;
	}
	
	
}