package com.tp.model;

import com.tp.model.dto.ApartmentTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apartment_type")
@Accessors(chain = true)
public class ApartmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;

    @OneToMany(targetEntity = Apartment.class, mappedBy = "apartmentType", fetch = FetchType.EAGER)
    private Set<Apartment> apartments;

    public ApartmentTypeDTO toApartmentTypeDTO(){
        return new ApartmentTypeDTO()
                .setId(id)
                .setCode(code)
                .setName(name);
    }

}
