package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    //MemberRepository 객체를 생성한다.
    MemberRepository repository = new MemoryMemberRepository();


    //callback 함수와 같음, 테스트가 실행되고나서 이후에 한번씩 실행됨 데이터를 지움
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
        //데이터를 저장하기 위해 model객체를 생성
        Member member = new Member();
        //model객체 필드인 Name에  스프링이라는 데이터를 넣어준다.
        member.setName("Spring");
        // repository객체의 메소드 save에 model객체를 전달
        repository.save(member);
        // repository객체의 findById아이디를 찾는 객체값이 제대로 저장 되었는지 가져온다.
        Member result = repository.findById(member.getId()).get();

        // 테스트 확인방법 sout로 논리연산자를 통해 찍어보기
        System.out.println("result = " + (result == member));
        // 마찬가지로 객체의 필드값을 찍어보기
        System.out.println(member.getId() + member.getName());

        //Assertions 값이 같은지 확인할 수 있는 클래스 메소드
        //Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        // member1 객체생성
        Member member1 = new Member();
        member1.setName("유재석");
        repository.save(member1);

        // member2 객체생성
        Member member2 = new Member();
        member2.setName("노홍철");
        repository.save(member2);

        //이름 찾는 메소드 실행후 결과값 받아오기
        Member result = repository.findByName("노홍철").get();
        //Assertion보다 더 알아보기 쉽고 이해하기 쉬운 assertThat사용
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findByAll() {


        // member1 객체생성
        Member member1 = new Member();
        member1.setName("유재석");
        repository.save(member1);

        // member2 객체생성
        Member member2 = new Member();
        member2.setName("노홍철");
        repository.save(member2);

        //저장된 모든 값을 리스트로 가져오기
        List<Member> result = repository.findAll();

        //결과 사이즈값이 2와 같은가?
        assertThat(result.size()).isEqualTo(2);
    }
}


