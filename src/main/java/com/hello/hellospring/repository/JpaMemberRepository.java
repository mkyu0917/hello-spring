package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; // jpa는 entity 매니저가 관리하므로 필드 명시

    //생성자 주입
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //setid 부터 insert까지 다 처리해줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //jpql 객체를 대상으로 쿼리를 날림, 객체자체를 셀렉트
        List<Member> result = em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();

        //스트림에서 가장 먼저 찾는 값을 가져오기
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //jpql 객체를 대상으로 쿼리를 날림 , 객체 자체를 셀렉트 필드를 명시할 필요가 없음.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
