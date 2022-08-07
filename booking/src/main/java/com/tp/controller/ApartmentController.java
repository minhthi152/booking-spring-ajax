package com.tp.controller;

import com.tp.model.BookingItem;
import com.tp.model.dto.BookingItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class ApartmentController {
    @GetMapping
    public ModelAndView showHomePage() {
//        BookingItemDTO  bookingItemDTO = new BookingItemDTO();
//        BookingItem bookingItem = bookingItemDTO.toBookingItem();
//
//        System.out.println(bookingItem);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/apartment/dashboard");
        return modelAndView;
    }
}
