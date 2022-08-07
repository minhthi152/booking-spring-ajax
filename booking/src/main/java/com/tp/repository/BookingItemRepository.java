package com.tp.repository;

import com.tp.model.BookingItem;
import com.tp.model.dto.BookingItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingItemRepository extends JpaRepository<BookingItem, Long> {
    @Query("SELECT NEW com.tp.model.dto.BookingItemDTO(b.id, b.checkInDate, b.checkOutDate, b.apartment, b.booking) FROM BookingItem AS b WHERE b.booking.id = ?1" )
    List<BookingItemDTO> findAllBookingDTO(Long id);


    @Query("SELECT NEW com.tp.model.dto.BookingItemDTO(b.id, b.checkInDate, b.checkOutDate, b.apartment, b.booking) FROM BookingItem AS b")
    List<BookingItemDTO> findAllBookingDTOs();



}
