package com.tp.service.apartmentType;

import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentTypeDTO;
import com.tp.repository.ApartmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApartmentTypeServiceImpl implements IApartmentTypeService{
    @Autowired
    private ApartmentTypeRepository apartmentTypeRepository;


    @Override
    public List<ApartmentType> findAll() {
        return apartmentTypeRepository.findAll();
    }

    public List<ApartmentTypeDTO> findAllApartmentTypeDTO(){
        return apartmentTypeRepository.findAllApartmentTypeDTO();
    }

    @Override
    public Optional<ApartmentTypeDTO> findApartmentTypeDTOById(Long id) {
        return apartmentTypeRepository.findApartmentTypeDTOById(id);
    }

    ;




    @Override
    public Optional<ApartmentType> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ApartmentType getById(Long id) {
        return null;
    }

    @Override
    public ApartmentType save(ApartmentType apartmentType) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
