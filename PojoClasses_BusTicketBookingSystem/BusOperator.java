package pojo;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusOperator {
    private int operatorID;
    private String operatorUsername;
    private String operatorPassword;
    private String operatorName;
    private String email;
    private String phoneNumber;
    private LocalDateTime registrationDate;
    
    //Default Constructor
	public BusOperator() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public BusOperator(int operatorID, String operatorUsername, String operatorPassword, String operatorName,
			String email, String phoneNumber, LocalDateTime registrationDate) {
		super();
		this.operatorID = operatorID;
		this.operatorUsername = operatorUsername;
		this.operatorPassword = operatorPassword;
		this.operatorName = operatorName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}

	//Getters and Setters Start
	
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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
    
	//Getters and Setters End
	
	
	//ToString Method
	
	@Override
	public String toString() {
		return "BusOperator [operatorID=" + operatorID + ", operatorUsername=" + operatorUsername
				+ ", operatorPassword=" + operatorPassword + ", operatorName=" + operatorName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", registrationDate=" + registrationDate + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(email, operatorID, operatorName, operatorPassword, operatorUsername, phoneNumber,
				registrationDate);
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
		BusOperator other = (BusOperator) obj;
		return Objects.equals(email, other.email) && operatorID == other.operatorID
				&& Objects.equals(operatorName, other.operatorName)
				&& Objects.equals(operatorPassword, other.operatorPassword)
				&& Objects.equals(operatorUsername, other.operatorUsername)
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(registrationDate, other.registrationDate);
	}
	
}
