package com.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @GetMapping
    public ModelAndView showBookingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/booking/booking");
        return modelAndView;
    }
}
