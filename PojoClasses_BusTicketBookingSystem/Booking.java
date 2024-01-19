package pojo;

import java.sql.Date;
import java.util.Objects;

public class Booking {
    private int bookingID;
    private int userID;
    private int scheduleID;
    private String seatNumber;
    private Date bookingDate;
    private PaymentStatus paymentStatus;
    private Date paymentDate;
    private RefundStatus refundStatus;
    
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
	public Booking(int bookingID, int userID, int scheduleID, String seatNumber, Date bookingDate,
			PaymentStatus paymentStatus, Date paymentDate, RefundStatus refundStatus) {
		super();
		this.bookingID = bookingID;
		this.userID = userID;
		this.scheduleID = scheduleID;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.refundStatus = refundStatus;
	}

	//Getters and Setters Start
	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
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
		return "Booking [bookingID=" + bookingID + ", userID=" + userID + ", scheduleID=" + scheduleID + ", seatNumber="
				+ seatNumber + ", bookingDate=" + bookingDate + ", paymentStatus=" + paymentStatus + ", paymentDate="
				+ paymentDate + ", refundStatus=" + refundStatus + "]";
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingID, paymentDate, paymentStatus, refundStatus, scheduleID, seatNumber,
				userID);
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
				&& refundStatus == other.refundStatus && scheduleID == other.scheduleID
				&& Objects.equals(seatNumber, other.seatNumber) && userID == other.userID;
	}  

}
