package com.tp.service.bookingItem;


import com.tp.model.BookingItem;
import com.tp.model.dto.BookingItemDTO;
import com.tp.repository.BookingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingItemServiceImpl implements IBookingItemService {

    @Autowired
    private BookingItemRepository bookingItemRepository;

    @Override
    public List<BookingItem> findAll() {
        return null;
    }

    @Override
    public List<BookingItemDTO> findAllBookingItemDTO(Long id) {

        return bookingItemRepository.findAllBookingDTO(id);
    }

    @Override
    public List<BookingItemDTO> findAllBookingItemDTOs() {
        return bookingItemRepository.findAllBookingDTOs();
    }

    @Override
    public Optional<BookingItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public BookingItem getById(Long id) {
        return null;
    }

    @Override
    public BookingItem save(BookingItem bookingItem) {
        return bookingItemRepository.save(bookingItem);
    }

    @Override
    public void remove(Long id) {

    }
}
