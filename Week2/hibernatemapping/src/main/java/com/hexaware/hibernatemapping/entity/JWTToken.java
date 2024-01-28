package com.hexaware.hibernatemapping.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JWTToken {
	@Id
	private int tokenId;
	private String token;
	private Date expirationDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BusOperatorId")
	private BusOperator busOperator;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId")
	private Admin admin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	public JWTToken() {
		
	}
	
	public JWTToken(int tokenId, String token, Date expirationDate) {
		super();
		this.tokenId = tokenId;
		this.token = token;
		this.expirationDate = expirationDate;
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public BusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setUser(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}