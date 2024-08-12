package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Booking;

public interface BookingService {

	List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    Booking saveBooking(Booking booking);
    void deleteBooking(Long id);
}
