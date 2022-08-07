package com.tp.controller.api;

import com.tp.model.dto.BookingItemDTO;
import com.tp.model.dto.CreateBookingDTO;
import com.tp.service.bookingItem.IBookingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookingItem")
public class BookingItemAPI {

    @Autowired
    private IBookingItemService bookingItemService;

    @GetMapping()
    public ResponseEntity<?> getAllBookingItems(){
        List<BookingItemDTO> bookingItemDTOS = bookingItemService.findAllBookingItemDTOs();

        if (bookingItemDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookingItemDTOS, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getAllBookingItem(@PathVariable Long id){
        List<BookingItemDTO> bookingItemDTOS = bookingItemService.findAllBookingItemDTO(id);

        if (bookingItemDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookingItemDTOS, HttpStatus.OK);
    }
}
