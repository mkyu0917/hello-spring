package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class templateController {

    @GetMapping("")
    public ModelAndView templates(ModelAndView mv){

        String sentance ="오오 너무나 멋지다.";


        mv.addObject("data",sentance);
        mv.setViewName("index");

        return mv;
    }
}
