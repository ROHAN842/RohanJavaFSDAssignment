package com.hexaware.hibernatemapping.services;

import com.hexaware.hibernatemapping.entity.User;
import com.hexaware.hibernatemapping.entity.BusRoute;
import com.hexaware.hibernatemapping.entity.BusSchedule;
import com.hexaware.hibernatemapping.entity.Booking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
public interface IUserService {

    boolean registerUser(User user);

    User loginUser(String usernameOrEmail, String password);

    List<BusRoute> searchBusRoutes(String origin, String destination, LocalDate date);

    List<String> getAutoSuggestions(String input);

    List<BusSchedule> getAvailableSchedules(int routeId);

    Map<String, Object> getFaresAndAmenities(int routeId, int numberOfSeats);

    boolean selectSeats(List<String> selectedSeats);

    BigDecimal calculateTotalPrice(int routeId, List<String> selectedSeats);

    boolean bookTickets(int userId, int routeId, List<String> selectedSeats);

    List<Booking> getBookingHistory(int userId);

    boolean cancelBooking(int bookingId);

    boolean updateUserProfile(User user);

    boolean changePassword(int userId, String newPassword);

    User getUserById(int userId);

    boolean deleteUser(int userId);

    boolean isUsernameAvailable(String username);

    boolean isEmailAvailable(String email);


}
