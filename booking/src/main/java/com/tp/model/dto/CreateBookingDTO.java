package com.tp.model.dto;

import com.tp.model.Booking;
import com.tp.model.BookingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateBookingDTO {

    private Long id;

    private String tenantName;

    private String tenantEmail;

    private String tenantPhone;

    private List<BookingItemDTO> bookingItems;

    public Booking toBooking() {
        return new Booking()
                .setId(id)
                .setTenantName(tenantName)
                .setTenantEmail(tenantEmail)
                .setTenantPhone(tenantPhone);
    }

}
