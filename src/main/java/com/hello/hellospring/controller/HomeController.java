package com.hello.hellospring.controller;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.domain.MemberForm;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    //Service 명시
    private final MemberService memberService;

    //의존성 주입
    @Autowired
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    //templates 경로에 있는 home.html 파일을 찾아서 브라우저에 뿌려줌
    @GetMapping("/")
    public ModelAndView home(ModelAndView mv){

        mv.setViewName("home");
        return mv;
    }

    //templates/members/createMemberForm.html 파일을 찾아서 뿌려줌
    @GetMapping("/members/new")
    public String createForm(){

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String join(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    } ;

}
