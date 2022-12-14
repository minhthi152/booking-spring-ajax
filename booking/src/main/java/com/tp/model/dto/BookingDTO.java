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

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookingDTO {

    private long id;

    private String tenantName;

    private String tenantEmail;

    private String tenantPhone;

    private List<BookingItemDTO>  bookingItemDTOList;

    public Booking toBooking(){
        return new Booking()
                .setId(id)
                .setTenantName(tenantName)
                .setTenantEmail(tenantEmail)
                .setTenantPhone(tenantPhone);
    }
}
