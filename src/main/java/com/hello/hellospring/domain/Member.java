package com.hello.hellospring.domain;


import javax.persistence.*;

//데이터를 시스템에 저장하기 위한 객체와 객체명
@Entity // jpa 객체설정
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  //pk는 db에서 알아서 생성해준다고 정의 IDENTITY
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
