package com.tp.service.apartment;

import com.tp.model.Apartment;
import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentDTO;
import com.tp.repository.ApartmentRepository;
import com.tp.repository.ApartmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements IApartmentService{

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private ApartmentTypeRepository apartmentTypeRepository;


    @Override
    public List<Apartment> findAll() {
        return null;
    }

    public List<Apartment> findAllByAvailableIsFalse(){
        return apartmentRepository.findAllByAvailableIsFalse();
    }


    public List<ApartmentDTO> findAllApartmentDTOByAvailableIsFalse(){
        return apartmentRepository.findAllApartmentDTOByAvailableIsFalse();
    }

    public Optional<ApartmentDTO> findApartmentDTOById(Long id){
        return apartmentRepository.findApartmentDTOById(id);
    }

    @Override
    public Apartment update(Apartment apartment) {
        ApartmentType apartmentType = apartmentTypeRepository.getById(apartment.getApartmentType().getId());

        apartment.setApartmentType(apartmentType);
        return apartmentRepository.save(apartment);
    }

    @Override
    public Optional<Apartment> findById(Long id) {
        return apartmentRepository.findById(id);
    }

    @Override
    public Apartment getById(Long id) {

        return apartmentRepository.getById(id);
    }

    @Override
    public Apartment save(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Apartment create(Apartment apartment) {
        ApartmentType apartmentType = apartmentTypeRepository.save(apartment.getApartmentType());

        apartment.setApartmentType(apartmentType);
        return  apartmentRepository.save(apartment);
    }

}
