package pojo;

import java.sql.Date;
import java.util.Objects;

public class JWTToken {
    private int tokenID;
    private int userID;
    private String token;
    private Date expirationTime;
    
    //Default Constructor
	public JWTToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public JWTToken(int tokenID, int userID, String token, Date expirationTime) {
		super();
		this.tokenID = tokenID;
		this.userID = userID;
		this.token = token;
		this.expirationTime = expirationTime;
	}

	//Getters and Setters Start
	public int getTokenID() {
		return tokenID;
	}

	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
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

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
    //Getters and Setters End

	//ToString Method
	@Override
	public String toString() {
		return "JWTToken [tokenID=" + tokenID + ", userID=" + userID + ", token=" + token + ", expirationTime="
				+ expirationTime + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(expirationTime, token, tokenID, userID);
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
		JWTToken other = (JWTToken) obj;
		return Objects.equals(expirationTime, other.expirationTime) && Objects.equals(token, other.token)
				&& tokenID == other.tokenID && userID == other.userID;
	}	
	
    
}
