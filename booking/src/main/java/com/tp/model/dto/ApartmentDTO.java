package com.tp.model.dto;

import com.tp.model.Apartment;
import com.tp.model.ApartmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ApartmentDTO implements Validator {

    private long id;

    @NotBlank(message = "Title cannot be empty.")
    private String title;
    private ApartmentTypeDTO apartmentTypeDTO;

    @Min(value = 5, message = "Area must be greater than 5m2")
    @NotBlank(message = "Area cannot be empty.")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "Area is only number.")
    private String area;

    @DecimalMin(value = "10", message = "Price is greater than $10", inclusive = false)
    @DecimalMax(value = "100000", message = "Price cannot exceed $100.000", inclusive = false)
    private BigDecimal price;

    @NotBlank(message = "Description cannot be empty.")
    private String description;

    private boolean kitchen;

    private boolean balcony;

    private boolean view;

    private boolean petAllowed;

    private boolean deleted;

    public ApartmentDTO(long id, String title, ApartmentType apartmentType, String area, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.apartmentTypeDTO = apartmentType.toApartmentTypeDTO();
        this.area = area;
        this.price = price;
        this.description = description;
    }

    public ApartmentDTO(long id, String title, ApartmentType apartmentType, String area, BigDecimal price, String description, boolean kitchen, boolean balcony, boolean view, boolean petAllowed, boolean deleted) {
        this.id = id;
        this.title = title;
        this.apartmentTypeDTO = apartmentType.toApartmentTypeDTO();
        this.area = area;
        this.price = price;
        this.description = description;
        this.kitchen = kitchen;
        this.balcony = balcony;
        this.view = view;
        this.petAllowed = petAllowed;
        this.deleted = deleted;
    }

    public Apartment toApartmentFormBooking() {
        return new Apartment()
                .setId(id);
    }

    public Apartment toApartment(){
        return new Apartment()
                .setId(id)
                .setTitle(title)
                .setApartmentType(apartmentTypeDTO.toApartmentType())
                .setArea(area)
                .setPrice(price)
                .setDescription(description)
                .setKitchen(kitchen)
                .setBalcony(balcony)
                .setView(view)
                .setPetAllowed(petAllowed)
                .setDeleted(deleted);
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return ApartmentDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApartmentDTO apartmentDTO = (ApartmentDTO) o;

        BigDecimal aptPrice = apartmentDTO.getPrice();
        String aptArea = apartmentDTO.getArea();

        if (aptPrice != null) {
            if (!aptPrice.toString().matches("(^$|[0-9]*$)")){
                errors.rejectValue("price", "price.matches", "Price is only number");
            }
        } else {
            errors.rejectValue("price", "price.null", "Price cannot be empty");
        }

        if(aptArea == null){
            errors.rejectValue("area", "area.null", "Area cannot be empty");
        }
    }
}
