package com.tp.repository;

import com.tp.model.ApartmentType;
import com.tp.model.dto.ApartmentTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApartmentTypeRepository extends JpaRepository<ApartmentType, Long> {

    @Query("SELECT NEW com.tp.model.dto.ApartmentTypeDTO (a.id, a.code, a.name) FROM ApartmentType a")
    List<ApartmentTypeDTO> findAllApartmentTypeDTO();

    @Query("SELECT NEW com.tp.model.dto.ApartmentTypeDTO (a.id, a.code, a.name) FROM ApartmentType a WHERE a.id = ?1")
    Optional<ApartmentTypeDTO> findApartmentTypeDTOById(Long id);


}
