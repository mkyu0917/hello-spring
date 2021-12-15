package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class templateController {

    @GetMapping("/MVC-Pattern")
    //@RequestParam으로 받은 파라미터를 String url라는 객체에 할당
    //defaultValue true가 기본값, false로 하면 파라미터를 안넘겨도 상관없음
    public ModelAndView templates(@RequestParam(name ="url", required = false) String url, ModelAndView mv){

        //url객체를 data라는 이름이라는 객체에 넣어 View에 전달
        mv.addObject("data",url);
        //ViewResolver가 mvcPage라는 화면을 찾는다.
        mv.setViewName("mvcPage");

        //mv객체를 mvcPage에 전달.
        return mv;
    }


    @GetMapping("/Api")
    @ResponseBody
    public String api(@RequestParam(value="test") String test){
     return "hello " +test;
    }


    @GetMapping("/Api-data")
    @ResponseBody
    public json json(@RequestParam(value="json") String json){

        json js = new json();
        js.setTest(json);
        return js;
    }

    @GetMapping("/Api-json")
    @ResponseBody
    public ModelAndView json(@RequestParam(value="json") String json, ModelAndView mv){

        json js = new json();

        js.setTest(json);
        mv.addObject("test",js);
        mv.setViewName("mvcPage");

        return mv;
    }

    static class json{

        String test;

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }
}
