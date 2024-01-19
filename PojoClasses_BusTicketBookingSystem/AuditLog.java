package pojo;

import java.sql.Date;
import java.util.Objects;

public class AuditLog {
    private int logID;
    private int userID;
    private String activityType;
    private Date activityTime;
    private String details;
    
    //Default Constructor
	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public AuditLog(int logID, int userID, String activityType, Date activityTime, String details) {
		super();
		this.logID = logID;
		this.userID = userID;
		this.activityType = activityType;
		this.activityTime = activityTime;
		this.details = details;
	}

	//Getters and Setters Start
	public int getLogID() {
		return logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	//Getters and Setters End

	//ToString Method
	@Override
	public String toString() {
		return "AuditLog [logID=" + logID + ", userID=" + userID + ", activityType=" + activityType + ", activityTime="
				+ activityTime + ", details=" + details + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(activityTime, activityType, details, logID, userID);
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
		AuditLog other = (AuditLog) obj;
		return Objects.equals(activityTime, other.activityTime) && Objects.equals(activityType, other.activityType)
				&& Objects.equals(details, other.details) && logID == other.logID && userID == other.userID;
	}
	    

}
