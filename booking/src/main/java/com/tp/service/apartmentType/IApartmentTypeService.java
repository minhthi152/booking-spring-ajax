package com.tp.service.apartmentType;

import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentTypeDTO;
import com.tp.service.IGeneralService;

import java.util.List;

public interface IApartmentTypeService extends IGeneralService<ApartmentType> {
    List<ApartmentTypeDTO> findAllApartmentTypeDTO();
}
