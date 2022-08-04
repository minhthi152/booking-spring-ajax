package com.tp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.tp.model.dto.BookingItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="booking_items")
@Accessors(chain = true)
public class BookingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "check_in_date")
    private Date checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "check_out_date")
    private Date checkOutDate;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public BookingItemDTO toBookingItemDTO(){
        return new BookingItemDTO()
                .setId(id)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .setApartmentDTO(apartment.toApartmentDTO());
    }


}
