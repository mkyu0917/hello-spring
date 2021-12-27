package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //(Dependency Injection이 아닌 객체를 새로 생성)
    MemberService memberService = new MemberService();


    // 회원가입 테스트
    @Test
    void join() {
        //member 객체를 생성
        Member member = new Member();
        member.setName("스트링");
        memberService.join(member);
    }

    // 중복회원가입 하는 사람이 있는지 테스트
    @Test
    void duplicateMember(){
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        //try catch로 테스트
        memberService.join(member1);

        /*try {
            memberService.join(member1);
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.111");
        }*/

        //assertion으로 테스트
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}