package pojo;

import java.sql.Date;
import java.util.Objects;

public class Session {
    private int sessionID; 
    private int userID;
    private String token; // JWT Token
    private Date loginTime;
    private Date logoutTime;
    
    //Default Constructor
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public Session(int sessionID, int userID, String token, Date loginTime, Date logoutTime) {
		super();
		this.sessionID = sessionID;
		this.userID = userID;
		this.token = token;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
	
	//Getters and Setters Start

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	//Getters and Setters End
	
	
	//ToString Method
	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", userID=" + userID + ", token=" + token + ", loginTime="
				+ loginTime + ", logoutTime=" + logoutTime + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(loginTime, logoutTime, sessionID, token, userID);
	}

	//Equals Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return Objects.equals(loginTime, other.loginTime) && Objects.equals(logoutTime, other.logoutTime)
				&& sessionID == other.sessionID && Objects.equals(token, other.token) && userID == other.userID;
	}
	
	
    
    
}
