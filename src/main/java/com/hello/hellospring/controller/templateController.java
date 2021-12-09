package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class templateController {

    @GetMapping("/MVC-Pattern")
    public ModelAndView templates(@RequestParam("url") String url, ModelAndView mv){




        mv.addObject("data",url);
        mv.setViewName("index");

        return mv;
    }
}
