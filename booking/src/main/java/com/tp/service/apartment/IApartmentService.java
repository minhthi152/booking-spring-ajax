package com.tp.service.apartment;

import com.tp.model.Apartment;
import com.tp.model.dto.ApartmentDTO;
import com.tp.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IApartmentService extends IGeneralService<Apartment>{

    List<Apartment> findAllByAvailableIsFalse();
    
    
    Apartment create(Apartment apartment);

    List<ApartmentDTO> findAllApartmentDTOByDeletedIsFalse();

    Optional<ApartmentDTO> findApartmentDTOById(Long id);

    Apartment update(Apartment apartment);
}
