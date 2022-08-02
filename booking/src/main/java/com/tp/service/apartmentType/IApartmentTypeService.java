package com.tp.service.apartmentType;

import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentTypeDTO;
import com.tp.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IApartmentTypeService extends IGeneralService<ApartmentType> {
    List<ApartmentTypeDTO> findAllApartmentTypeDTO();

    Optional<ApartmentTypeDTO> findApartmentTypeDTOById(Long id);
}
