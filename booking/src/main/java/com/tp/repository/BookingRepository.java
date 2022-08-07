package com.tp.repository;

import com.tp.model.Booking;
import com.tp.model.dto.BookingDTO;
import com.tp.model.dto.CreateBookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

        @Query("SELECT NEW com.tp.model.dto.CreateBookingDTO (" +
                "b.id, " +
                "b.tenantName, " +
                "b.tenantEmail, " +
                "b.tenantPhone " +
            ") " +
            "FROM Booking b"
    )
    List<CreateBookingDTO> findAllBookingDTO();

}
