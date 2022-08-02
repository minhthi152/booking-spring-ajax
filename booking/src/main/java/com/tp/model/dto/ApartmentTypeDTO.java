package com.tp.model.dto;

import com.tp.model.ApartmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ApartmentTypeDTO {
    private Long id;

    private String code;

    private String name;

    public ApartmentType toApartmentType(){
        return new ApartmentType()
                .setId(id)
                .setCode(code)
                .setName(name);
    }



}
