package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은 나오지 않도록 조회
        // Command + option + v 자동 리턴생성
        duplicationMemberCheck(member); // 중복체크
        memberRepository.save(member);
        return member.getId();
    }

    private void duplicationMemberCheck(Member member) {
        //메소드를 실행하면 리턴 타입이 Optional 객체이므로 ifPresent를 바로 사용가능하다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    // throw new 로 Exception객체를 생성하면 원하는 문장을 출력하게 가능
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
