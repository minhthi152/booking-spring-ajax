package com.tp.controller.api;

import com.tp.exception.DataInputException;
import com.tp.exception.ResourceNotFoundException;
import com.tp.model.Apartment;
import com.tp.model.Booking;
import com.tp.model.BookingItem;
import com.tp.model.dto.ApartmentDTO;
import com.tp.model.dto.BookingDTO;
import com.tp.model.dto.BookingItemDTO;
import com.tp.service.apartment.IApartmentService;
import com.tp.service.booking.IBookingService;
import com.tp.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingAPI {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IApartmentService apartmentService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping
    public ResponseEntity<?> getAllBooking(){
        List<BookingDTO> bookingDTOS = bookingService.findAllBookingDTO();

        if (bookingDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookingDTOS, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO, BindingResult bindingResult){


        bookingDTO.setId(0);
        try {

            List<BookingItemDTO> bookingItemDTOList = bookingDTO.getBookingItemDTOList();
            List<BookingItem> bookingItemList = new ArrayList<>();

            for (BookingItemDTO bookingItemDTO: bookingItemDTOList) {
                bookingItemList.add(bookingItemDTO.toBookingItem());
            }

            Booking createdBooking = bookingService.create(bookingDTO.toBooking(bookingItemList));

            bookingDTO = createdBooking.toBookingDTO(bookingItemDTOList);

            return new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Customer creation information is not valid, please check the information again");
        }

    }


}
