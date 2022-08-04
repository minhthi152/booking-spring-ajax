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

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookingItemDTO {

    private long id;

//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private Date checkInDate;

//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private Date checkOutDate;

    private ApartmentDTO apartmentDTO;

    private BookingDTO bookingDTO;

    public BookingItem toBookingItem(){
        return new BookingItem()
                .setId(id)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setApartment(apartmentDTO.toApartment());
    }



}
