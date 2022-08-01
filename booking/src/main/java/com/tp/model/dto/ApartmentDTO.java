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

    @NotBlank(message = "Title cannot be blank.")
    private String title;
    private ApartmentTypeDTO apartmentTypeDTO;
    @NotBlank(message = "Area cannot be blank.")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "Area is only number.")

    @Min(value = 5, message = "Area must be greater than 5m2")
    private String area;

    @DecimalMin(value = "1", message = "Price cannot be negative", inclusive = false)
    @DecimalMax(value = "100000", message = "Price cannot exceed $100.000", inclusive = false)
    private BigDecimal price;

    @NotBlank(message = "Description cannot be blank.")
    private String description;

    private boolean kitchen;

    private boolean balcony;

    private boolean view;

    private boolean petAllowed;

    public ApartmentDTO(long id, String title, ApartmentType apartmentType, String area, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.apartmentTypeDTO = apartmentType.toApartmentTypeDTO();
        this.area = area;
        this.price = price;
        this.description = description;
    }

    public ApartmentDTO(long id, String title, ApartmentType apartmentType, String area, BigDecimal price, String description, boolean kitchen, boolean balcony, boolean view, boolean petAllowed) {
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
                .setPetAllowed(petAllowed);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApartmentDTO apartmentDTO = (ApartmentDTO) o;
        BigDecimal price = apartmentDTO.getPrice();

//        if(price.compareTo(BigDecimal.ZERO) <= 0) {
//            errors.rejectValue("price", "error.price.");
//        }


    }
}
