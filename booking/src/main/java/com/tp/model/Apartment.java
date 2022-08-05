package com.tp.model;

import com.tp.model.dto.ApartmentDTO;
import com.tp.model.dto.BookingApartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="apartments")
@Accessors(chain = true)
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "apartment_type_id", referencedColumnName = "id")
    private ApartmentType apartmentType;

    private String area;

    @Column(nullable = false)
    @Digits(integer = 12, fraction = 0)
    private BigDecimal price;

    @Column(columnDefinition = "boolean default true")
    private boolean available;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean kitchen;

    @Column(columnDefinition = "boolean default false")
    private boolean balcony;

    @Column(columnDefinition = "boolean default false")
    private boolean view;

    @Column(name = "pet_allowed", columnDefinition = "boolean default false")
    private boolean petAllowed;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    public ApartmentDTO toApartmentDTO(){
        return new ApartmentDTO()
                .setId(id)
                .setTitle(title)
                .setApartmentTypeDTO(apartmentType.toApartmentTypeDTO())
                .setArea(area)
                .setPrice(price)
                .setDescription(description)
                .setKitchen(kitchen)
                .setBalcony(balcony)
                .setView(view)
                .setPetAllowed(petAllowed)
                .setDeleted(deleted);
    }

    public BookingApartmentDTO toBookingApartmentDTO() {
        return new BookingApartmentDTO()
                .setId(id);
    }

}
