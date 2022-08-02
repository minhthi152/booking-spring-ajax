package com.tp.controller.api;

import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentTypeDTO;
import com.tp.service.apartmentType.IApartmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/apartmentType")
public class ApartmentTypeAPI {
    @Autowired
    IApartmentTypeService apartmentTypeService;

    @GetMapping
    public ResponseEntity<?> getAllAptType () {
        List<ApartmentTypeDTO> apartmentTypes = apartmentTypeService.findAllApartmentTypeDTO();

        return new ResponseEntity<>(apartmentTypes, HttpStatus.OK);
    }


}
