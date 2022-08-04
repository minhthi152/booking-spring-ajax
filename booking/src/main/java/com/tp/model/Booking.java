package com.tp.model;

import com.tp.model.dto.BookingDTO;
import com.tp.model.dto.BookingItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bookings")
@Accessors(chain = true)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tenant_name")
    private String tenantName;

    @Column(name = "tenant_email")
    private String tenantEmail;

    @Column(name = "tenant_phone")
    private String tenantPhone;

    @OneToMany
    @Column(name = "booking_item")
    private List<BookingItem> bookingItemList;


    public BookingDTO toBookingDTO(List<BookingItemDTO> bookingItemDTOList){
        return new BookingDTO()
                .setId(id)
                .setTenantName(tenantName)
                .setTenantEmail(tenantEmail)
                .setTenantPhone(tenantPhone)
                .setBookingItemDTOList(bookingItemDTOList);
    }
}
