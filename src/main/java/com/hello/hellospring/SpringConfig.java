package com.hello.hellospring;

import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//수동으로 의존관계 만들기
//@Configuration 설정파일 또는 Bean을 등록하기 위한 어노테이션
@Configuration
public class SpringConfig {

    @Bean// spring di container에 의에 관리되는 객체를 생성 및 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

// Bean과 Component 둘다 객체로 등록이 가능하지만 레벨이다름
// Bean은 method 레벨, Component는 Class 레벨의 객체를 등록함
// Component는 스프링이 컴포넌트스캔을 사용해서 자동으로 빈을 등록함
// Bean은 객체를 개발자가 수동으로 빈으로 등록

//xml 방식은 최근에는 잘 사용안함

//DI에는 필드, setter, 생성자 주입이 있다.


// 필드주입 @Autowired private MemberService memberService;

// setter 주입
// @Autowired
// public void setMemberService(MemberService memberService) {
//  this.memberService = memberService;
// }

// 생성자 주입
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

// 이 주입들의 장단점을 비교해보면
// 필드 주입과 setter 주입은 final을 사용할 수 없기 때문에 나중에 변경이 될수 있어 불변성을 가지지 못한다.
// 보통은 한번 선언하면 건들일이 없다.

// 생성자주입같은 경우는 final을 선언하여 불변성을 갖게 할 수 있음

