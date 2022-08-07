package com.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/404")
public class NotFoundController {
    @GetMapping
    public ModelAndView showErrorPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }
}
