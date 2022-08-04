package com.tp.service.booking;

import com.tp.model.Booking;
import com.tp.model.BookingItem;
import com.tp.model.dto.BookingDTO;
import com.tp.repository.ApartmentRepository;
import com.tp.repository.BookingItemRepository;
import com.tp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private BookingItemRepository bookingItemRepository;

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public List<BookingDTO> findAllBookingDTO() {
        return bookingRepository.findAllBookingDTO();
    }

    @Override
    public Booking create(Booking booking) {

        List<BookingItem> bookingItemList = booking.getBookingItemList();
        for (BookingItem bookingItem: bookingItemList) {
            bookingItemRepository.save(bookingItem);
        }

        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Booking getById(Long id) {
        return null;
    }

    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
