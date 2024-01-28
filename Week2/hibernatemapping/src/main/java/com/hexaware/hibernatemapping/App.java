package com.hexaware.hibernatemapping;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernatemapping.entity.User;
import com.hexaware.hibernatemapping.entity.Booking;
import com.hexaware.hibernatemapping.entity.Booking.PaymentStatus;
import com.hexaware.hibernatemapping.entity.Booking.RefundStatus;

public class App {
	// many to one has similar mapping as one to many there is no seperate thing for many to one 
	public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction txn = session.beginTransaction();
        
        //Already inserted below data that's why commented else it will throw duplicate error as studentId is declared as primary key
//and for all the below transactions it will throw error 
        
//        Employee e1 = new Employee(109,"Rajesh",15000);
//        Employee e2 = new Employee(110,"Suresh",22000);
//        Employee e3 = new Employee(111,"Kamal",91000);
//        Employee e4 = new Employee(112,"Narendra",120000);
//        
//        	
//        Department dept1 = new Department();
//        dept1.setDepartmentId(30);
//        dept1.setDepartmentName("Development");
//        
//        
//        dept1.addEmployee(e1);
//        dept1.addEmployee(e2); 
//        dept1.addEmployee(e3);
//        dept1.addEmployee(e4);

 //       session.persist(dept1);
        
     // Sample values for creating a Booking object
        int bookingID = 1;
        // int userID = 101;
        //int scheduleID = 201;
        String seatNumber = "A1";
        Date bookingDate = Date.valueOf("2024-01-28"); // Sample booking date
        PaymentStatus paymentStatus = PaymentStatus.PENDING; // Sample payment status
        Date paymentDate = Date.valueOf("2024-01-29"); // Sample payment date
        RefundStatus refundStatus = RefundStatus.PENDING; // Sample refund status

        // Creating a Booking object with sample values
        Booking b1 = new Booking(bookingID, seatNumber,
                                      bookingDate, paymentStatus, paymentDate, refundStatus);

        
        User usr1 = new User();
        // usr1.setUserID(100);
        usr1.setUsername("jane_doe");
        usr1.setPassword("password456");
        usr1.setEmail("jane.doe@example.com");
        usr1.setFirstName("Jane");
        usr1.setLastName("Doe");
        usr1.setPhoneNumber("9876543210");
        usr1.setAddress("456 Elm Street, City, Country");
        usr1.setRegistrationDate(LocalDateTime.now());
        
        b1.setUser(usr1);

        usr1.addBooking(b1);
        session.persist(usr1);
        txn.commit();
        
        session.close();
	}

}

