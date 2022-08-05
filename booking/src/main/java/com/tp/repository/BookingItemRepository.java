package com.tp.repository;

import com.tp.model.BookingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingItemRepository extends JpaRepository<BookingItem, Long> {
}
