package com.hello.hellospring.controller;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //컨트롤러라는 것을 명시 Spring이 이 어노테이션을 보고 객체를 생성해서 갖고 있음
public class MemberController {

    // 이 형식대로도 서비스를 가져다 쓸 수 있지만 객체를 계속 생성하여 쓰는것보다 스프링에 하나만 등록하여 어러가지로 쓰는게 좋음
    //private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
