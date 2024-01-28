package com.hexaware.hibernatemapping.services;

import com.hexaware.hibernatemapping.entity.BusRoute;
import com.hexaware.hibernatemapping.entity.BusSchedule;
import com.hexaware.hibernatemapping.entity.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface IBusOperatorService {
    // Adds a new bus route
    boolean addBusRoute(BusRoute busRoute);

    // Edits an existing bus route
    boolean editBusRoute(BusRoute busRoute);

    // Removes a bus route
    boolean removeBusRoute(int routeId);

    // Adds a new bus schedule
    boolean addBusSchedule(BusSchedule busSchedule);

    // Edits an existing bus schedule
    boolean editBusSchedule(BusSchedule busSchedule);

    // Removes a bus schedule
    boolean removeBusSchedule(int scheduleId);

    // Sets fares for a specific route
    boolean setFares(int routeId, BigDecimal fare);

    // Manages seat availability for a specific schedule
    boolean manageSeatAvailability(int scheduleId, int availableSeats);

    // Views the tickets booked for a specific bus schedule
    List<Booking> viewBookedTickets(int scheduleId);

    // Refunds the amount for cancelled tickets on a specific bus schedule
    boolean refundCancelledTickets(int scheduleId);

}
