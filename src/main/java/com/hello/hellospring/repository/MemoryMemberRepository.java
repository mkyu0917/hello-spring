package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //전위 증감연산자(먼저 증감후에 변수에 할당, 후위는 저장후에 증감)
        store.put(member.getId(), member); // member 도메인에 할당된아이디 값을 key, member객체를 value에 넣음
        return member;// member 객체 리턴

    }

    @Override
    public Optional<Member> findById(Long id) {
        // null 값이 나올 것을 대비해서 Optional기능 사용
        return Optional.ofNullable(store.get(id)); //Optional 기능으로 값이 null이면 null출력
    }

    @Override
    public Optional<Member> findByName(String name) {
        //람다식 사용 (메서드를 하나의 식으로 표현한 것)

        return store.values().stream()//store의 값들을 읽어서
                .filter(member -> member.getName().equals(name))//필터로 member객체에 있는 getName의 값 파라미터 값이 같은것중
               .findAny();// 가장 먼저 나오는 값을 찾아라
               // 자매품 findFirst(조건에 일치하는 요소들중 순서가 가장 앞에 있는것을 가져와라)

    }

    @Override
    public List<Member> findAll() {
        // store map에 있는 모든 값을 리스트 객체에 할당해서 반환해라
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
