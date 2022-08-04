package com.tp.controller.api;

import com.tp.exception.DataInputException;
import com.tp.exception.ResourceNotFoundException;
import com.tp.model.Apartment;
import com.tp.model.dto.ApartmentDTO;
import com.tp.model.dto.ApartmentTypeDTO;
import com.tp.service.apartment.IApartmentService;
import com.tp.service.apartmentType.IApartmentTypeService;
import com.tp.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentAPI {

    @Autowired
    private IApartmentService apartmentService;

    @Autowired
    private IApartmentTypeService apartmentTypeService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {

        List<ApartmentDTO> apartments = apartmentService.findAllApartmentDTOByDeletedIsFalse();

        if (apartments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<List<?>> searchByWord(@PathVariable String word) {

        List<ApartmentDTO> apartments = apartmentService.searchAllByWord(word);

        if (apartments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> showUpdateForm(@PathVariable Long id) {

        Optional<ApartmentDTO> apartmentDTO = apartmentService.findApartmentDTOById(id);


        if (apartmentDTO.isPresent()) {


            return new ResponseEntity<>(apartmentDTO.get(), HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("No apartment found with the Id: " + id);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ApartmentDTO apartmentDTO, BindingResult bindingResult){

        new ApartmentDTO().validate(apartmentDTO, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return appUtil.mapErrorToResponse(bindingResult);
        }

        Optional<ApartmentTypeDTO> apartmentTypeDTO = apartmentTypeService.findApartmentTypeDTOById(apartmentDTO.getApartmentTypeDTO().getId());

        if(!apartmentTypeDTO.isPresent()){
            throw new ResourceNotFoundException("Apartment type ID does not exist.");
        }

        apartmentDTO.setId(0);

        try {
            Apartment createdApartment = apartmentService.create(apartmentDTO.toApartment());

            return new ResponseEntity<>(createdApartment.toApartmentDTO(), HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DataInputException("Invalid apartment creation information, please check the information again!");
        }

    }


    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody ApartmentDTO apartmentDTO, BindingResult bindingResult){
        new ApartmentDTO().validate(apartmentDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Optional<ApartmentTypeDTO> apartmentTypeDTO = apartmentTypeService.findApartmentTypeDTOById(apartmentDTO.getApartmentTypeDTO().getId());

        if(!apartmentTypeDTO.isPresent()){
            throw new ResourceNotFoundException("Apartment type ID does not exist.");
        }

        Apartment updatedApartment = apartmentService.update(apartmentDTO.toApartment());
        apartmentDTO = updatedApartment.toApartmentDTO();

        return new ResponseEntity<>(apartmentDTO, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> doDelete(@PathVariable Long id) {
        Optional<Apartment> apartment = apartmentService.findById(id);

        if (apartment.isPresent()) {
            try {
                apartment.get().setDeleted(true);
                apartmentService.save(apartment.get());

                return new ResponseEntity<>(HttpStatus.ACCEPTED);

            } catch (DataIntegrityViolationException e) {
                throw new DataInputException("Invalid suspension information");
            }
        } else {
            throw new DataInputException("Invalid apartment information");
        }
    }
}
