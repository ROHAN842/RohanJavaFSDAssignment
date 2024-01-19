package pojo;
import java.sql.Date;
import java.util.Objects;

public class BusSchedule {
    private int scheduleID;
    private int routeID;
    private int operatorID;
    private int availableSeats;
    private Date date;
    private Status status;
    
    // Enum for Status
    public enum Status {
        ACTIVE, INACTIVE
    }

    //Default Constructor
	public BusSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public BusSchedule(int scheduleID, int routeID, int operatorID, int availableSeats, Date date, Status status) {
		super();
		this.scheduleID = scheduleID;
		this.routeID = routeID;
		this.operatorID = operatorID;
		this.availableSeats = availableSeats;
		this.date = date;
		this.status = status;
	}

	//Getters and Setters Start
	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    //Getters and Setters End

	//ToString Method
	@Override
	public String toString() {
		return "BusSchedule [scheduleID=" + scheduleID + ", routeID=" + routeID + ", operatorID=" + operatorID
				+ ", availableSeats=" + availableSeats + ", date=" + date + ", status=" + status + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(availableSeats, date, operatorID, routeID, scheduleID, status);
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
		BusSchedule other = (BusSchedule) obj;
		return availableSeats == other.availableSeats && Objects.equals(date, other.date)
				&& operatorID == other.operatorID && routeID == other.routeID && scheduleID == other.scheduleID
				&& status == other.status;
	}
	

}
