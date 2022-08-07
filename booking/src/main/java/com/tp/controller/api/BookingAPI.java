package com.tp.controller.api;

import com.tp.exception.DataInputException;
import com.tp.exception.ResourceNotFoundException;
import com.tp.model.Apartment;
import com.tp.model.Booking;
import com.tp.model.BookingItem;
import com.tp.model.dto.*;
import com.tp.service.apartment.IApartmentService;
import com.tp.service.booking.IBookingService;
import com.tp.service.bookingItem.IBookingItemService;
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
    private IBookingItemService bookingItemService;

    @Autowired
    private IApartmentService apartmentService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping
    public ResponseEntity<?> getAllBooking(){
        List<CreateBookingDTO> bookingDTOS = bookingService.findAllBookingDTO();

        if (bookingDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookingDTOS, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CreateBookingDTO bookingDTO, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return appUtil.mapErrorToResponse(bindingResult);
        }
        bookingDTO.setId(0L);

        try {

            Booking booking = bookingDTO.toBooking();

            Booking bookingSaved = bookingService.save(booking);
            BookingDTO bookingDTONew = bookingSaved.toBookingDTO();

            List<BookingItemDTO> bookingItemDTOS = bookingDTO.getBookingItems();

//            List<BookingItem> bookingItemList = new ArrayList<>();

            for (BookingItemDTO bookingItemDTO: bookingItemDTOS) {
                bookingItemDTO.setId(0L);
                bookingItemDTO.setBooking(bookingDTONew);
//                bookingItemList.add(bookingItemDTO.toBookingItem());
                BookingItem bookingItem = bookingItemDTO.toBookingItem();
                bookingItemService.save(bookingItem);
            }

            bookingDTO.setId(bookingDTONew.getId());


            return new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Booking creation information is not valid, please check the information again");
        }

    }


}
