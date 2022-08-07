package com.tp.model.dto;

import com.tp.model.Booking;
import com.tp.model.BookingItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CreateBookingDTO {

    private Long id;
    @NotBlank(message = "Tenant name can not be blank.")
    private String tenantName;
    @NotBlank(message = "Tenant email can not be blank.")
    private String tenantEmail;
    @NotBlank(message = "Tenant phone can not be blank.")
    private String tenantPhone;

    private List<BookingItemDTO> bookingItems;
    public CreateBookingDTO(Long id, String tenantName, String tenantEmail, String tenantPhone) {
        this.id = id;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantPhone = tenantPhone;

    }

    public Booking toBooking() {
        return new Booking()
                .setId(id)
                .setTenantName(tenantName)
                .setTenantEmail(tenantEmail)
                .setTenantPhone(tenantPhone);
    }

}
