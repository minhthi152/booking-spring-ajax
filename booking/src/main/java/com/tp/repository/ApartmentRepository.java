package com.tp.repository;

import com.tp.model.Apartment;
import com.tp.model.dto.ApartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findAllByAvailableIsFalse();

    @Query("SELECT NEW com.tp.model.dto.ApartmentDTO (a.id, a.title, a.apartmentType, a.area, a.price, a.description) FROM Apartment a WHERE a.deleted = false")
    List<ApartmentDTO> findAllApartmentDTOByDeletedIsFalse();

    @Query("SELECT NEW com.tp.model.dto.ApartmentDTO (a.id, a.title, a.apartmentType, a.area, a.price, a.description, a.kitchen, a.balcony, a.view, a.petAllowed, a.deleted) FROM Apartment a WHERE a.deleted = false AND a.id = ?1 ")
    Optional<ApartmentDTO> findApartmentDTOById(Long id);

    @Query("SELECT NEW com.tp.model.dto.ApartmentDTO (a.id, a.title, a.apartmentType, a.area, a.price, a.description) FROM Apartment AS a JOIN ApartmentType AS at ON a.apartmentType.id = at.id WHERE a.deleted = false AND CONCAT(a. id, a.title, a.apartmentType, a.area, a.price, a.description, at.name) LIKE %?1%")
    List<ApartmentDTO> search(String keyword);
}
