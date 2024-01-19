package pojo;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class BusRoute {
    private int routeID;
    private String busNumber;
    private BusType busType;
    private String origin;
    private String destination;
    private Time timings;
    private BigDecimal fare;
    private Set<Amenities> amenities;
    
    // Enum for BusType
    public enum BusType {
        SLEEPER_WITH_AC, SLEEPER_WITHOUT_AC, SEAT_WITH_AC, SEAT_WITHOUT_AC
    }

    // Enum for Amenities
    public enum Amenities {
        WATER_BOTTLE, CHARGING_POINT, TV, BLANKET
    }

    //Default Constructor
	public BusRoute() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public BusRoute(int routeID, String busNumber, BusType busType, String origin, String destination, Time timings,
			BigDecimal fare, Set<Amenities> amenities) {
		super();
		this.routeID = routeID;
		this.busNumber = busNumber;
		this.busType = busType;
		this.origin = origin;
		this.destination = destination;
		this.timings = timings;
		this.fare = fare;
		this.amenities = amenities;
	}

	//Getters and Setters Start
	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Time getTimings() {
		return timings;
	}

	public void setTimings(Time timings) {
		this.timings = timings;
	}

	public BigDecimal getFare() {
		return fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	public Set<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<Amenities> amenities) {
		this.amenities = amenities;
	}
	//Getters and Setters End

	
	//ToString Method
	@Override
	public String toString() {
		return "BusRoute [routeID=" + routeID + ", busNumber=" + busNumber + ", busType=" + busType + ", origin="
				+ origin + ", destination=" + destination + ", timings=" + timings + ", fare=" + fare + ", amenities="
				+ amenities + "]";
	}
	
	
    //HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(amenities, busNumber, busType, destination, fare, origin, routeID, timings);
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
		BusRoute other = (BusRoute) obj;
		return Objects.equals(amenities, other.amenities) && Objects.equals(busNumber, other.busNumber)
				&& busType == other.busType && Objects.equals(destination, other.destination)
				&& Objects.equals(fare, other.fare) && Objects.equals(origin, other.origin) && routeID == other.routeID
				&& Objects.equals(timings, other.timings);
	}
	
    
}
