package com.tp.repository;

import com.tp.model.Booking;
import com.tp.model.dto.BookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
//    @Query("SELECT NEW com.tp.model.dto.BookingDTO (b.id, b.tenantName, b.tenantEmail, b.tenantPhone, b.bookingItemList) FROM Booking b")
//    List<BookingDTO> findAllBookingDTO();

}
