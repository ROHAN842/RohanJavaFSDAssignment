package com.hexaware.hibernatemapping.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//Since we're already mapping the User entity using @ManyToOne association, 
//you don't need to manually include the userID field in the Booking entity.
@Entity
public class Booking { 
	@Id	
    private int bookingID;
    private String seatNumber;
    private Date bookingDate;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Date paymentDate;
    @Enumerated(EnumType.STRING)
    private RefundStatus refundStatus;
     
    //for many to one relationship between booking to user 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User user;
    
    //for many to one relationship between booking to busSchedule 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduleID")
    private BusSchedule busSchedule;

    
    
//    The cascade attribute determines how changes to an entity should be propagated to associated entities. In a many-to-one 
//    relationship, it specifies what should happen to the associated User entity when a change is made to the Booking entity.
  
//    If we want operations such as persist, merge, remove, and refresh to be cascaded from the Booking entity to the associated User 
//    entity,then including cascade = CascadeType.ALL is appropriate. This means that when you perform any of these operations on 
//    a Booking, the corresponding operation will be cascaded to the associated User    
    
    // Enum for PaymentStatus
    public enum PaymentStatus {
        PENDING, COMPLETED
    }

    // Enum for RefundStatus
    public enum RefundStatus {
        PENDING, PROCESSED
    }

    //Default Constructor
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized Constructor
	public Booking(int bookingID, String seatNumber, Date bookingDate,
			PaymentStatus paymentStatus, Date paymentDate, RefundStatus refundStatus) {
		super();
		this.bookingID = bookingID;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.refundStatus = refundStatus;
	}

	//Get User method created while mapping many to one relationship between booking to user
    public User getUser() {
        return user;
    }
    //Set User method created while mapping many to one relationship between booking to user
    public void setUser(User user) {
        this.user = user;
    }
	
	//Get User method created while mapping many to one relationship between booking to BusSchedule
    public User getBusSchedule() {
        return user;
    }
    //Set User method created while mapping many to one relationship between booking to BusSchedule
    public void setBusSchedule(BusSchedule busSchedule) {
        this.busSchedule = busSchedule;
    }
    
    
    
	//Getters and Setters Start

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}


	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public RefundStatus getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(RefundStatus refundStatus) {
		this.refundStatus = refundStatus;
	}
	//Getters and Setters End

	//ToString Method
	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", seatNumber="
				+ seatNumber + ", bookingDate=" + bookingDate + ", paymentStatus=" + paymentStatus + ", paymentDate="
				+ paymentDate + ", refundStatus=" + refundStatus + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingID, paymentDate, paymentStatus, refundStatus, seatNumber);
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
		Booking other = (Booking) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingID == other.bookingID
				&& Objects.equals(paymentDate, other.paymentDate) && paymentStatus == other.paymentStatus
				&& refundStatus == other.refundStatus && Objects.equals(seatNumber, other.seatNumber);
	}  

}

