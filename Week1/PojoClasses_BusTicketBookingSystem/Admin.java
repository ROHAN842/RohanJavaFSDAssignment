package pojo;

import java.sql.Date;
import java.util.Objects;

public class Admin {
	private int adminID;
	private String adminUsername;
	private String adminPassword;
	private String email;
	private String phoneNumber;
	private Date registrationDate;
	private int managedUserID; // Foreign key referencing User table
	private int managedOperatorID; // Foreign key referencing BusOperator table
	
	//Default Constructor
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor 
	public Admin(int adminID, String adminUsername, String adminPassword, String email, String phoneNumber,
			Date registrationDate, int managedUserID, int managedOperatorID) {
		super();
		this.adminID = adminID;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
		this.managedUserID = managedUserID;
		this.managedOperatorID = managedOperatorID;
	}

	//Getters and Setters Start
	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
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

	public int getManagedUserID() {
		return managedUserID;
	}

	public void setManagedUserID(int managedUserID) {
		this.managedUserID = managedUserID;
	}

	public int getManagedOperatorID() {
		return managedOperatorID;
	}

	public void setManagedOperatorID(int managedOperatorID) {
		this.managedOperatorID = managedOperatorID;
	}
	//Getters and Setters End

	
	//ToString Method
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", registrationDate=" + registrationDate
				+ ", managedUserID=" + managedUserID + ", managedOperatorID=" + managedOperatorID + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(adminID, adminPassword, adminUsername, email, managedOperatorID, managedUserID, phoneNumber,
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
		Admin other = (Admin) obj;
		return adminID == other.adminID && Objects.equals(adminPassword, other.adminPassword)
				&& Objects.equals(adminUsername, other.adminUsername) && Objects.equals(email, other.email)
				&& managedOperatorID == other.managedOperatorID && managedUserID == other.managedUserID
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(registrationDate, other.registrationDate);
	}
	
	
	

}
