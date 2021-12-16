package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//Repository interface db에 접근하기 위한 메소드의 틀을 생성한다.
//구현체가 아닌 틀만 작성하기에 구현체를 생성해줘야한다.
public interface MemberRepository {
    Member save(Member member);
    //Optional 은 자바 8 문법으로 null check를 해주는 기능이다.
    //findById를 찾지 못했을때 NPE가 발생했을때 여러가지 방식으로 처리가 가능하다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    void clearStore();
}
