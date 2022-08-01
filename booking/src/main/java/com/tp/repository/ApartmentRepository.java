package com.tp.repository;

import com.tp.model.Apartment;
import com.tp.model.dto.ApartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findAllByAvailableIsFalse();

    @Query("SELECT NEW com.tp.model.dto.ApartmentDTO (a.id, a.title, a.apartmentType, a.area, a.price, a.description) FROM Apartment a WHERE a.available = false")
    List<ApartmentDTO> findAllApartmentDTOByAvailableIsFalse();

    @Query("SELECT NEW com.tp.model.dto.ApartmentDTO (a.id, a.title, a.apartmentType, a.area, a.price, a.description, a.kitchen, a.balcony, a.view, a.petAllowed) FROM Apartment a WHERE a.available = false AND a.id = ?1 ")
    Optional<ApartmentDTO> findApartmentDTOById(Long id);
}
