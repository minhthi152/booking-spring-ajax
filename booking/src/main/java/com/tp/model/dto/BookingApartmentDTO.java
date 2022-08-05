package com.tp.model.dto;


import com.tp.model.Apartment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class BookingApartmentDTO {
    private Long id;

    public Apartment toApartment() {
        return new Apartment()
                .setId(id);
    }


}
