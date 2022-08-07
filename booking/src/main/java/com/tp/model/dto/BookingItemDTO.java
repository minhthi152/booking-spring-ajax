package com.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tp.model.Apartment;
import com.tp.model.Booking;
import com.tp.model.BookingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookingItemDTO {

    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private Date checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private Date checkOutDate;

    private BookingApartmentDTO apartment;

    private BookingDTO booking;

    public BookingItemDTO(long id, Date checkInDate, Date checkOutDate, Apartment apartment, Booking booking) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.apartment = apartment.toBookingApartmentDTO();
        this.booking = booking.toBookingDTO();
    }

    public BookingItem toBookingItem(){
        return new BookingItem()
                .setId(id)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setApartment(apartment.toApartment())
                .setBooking(booking.toBooking());
    }

}
