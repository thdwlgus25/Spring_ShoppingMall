package inhatc.spring.shop.entity;

import jakarta.persistence.*;

@Entity // 데이터베이스를 만들 수 있음
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    @Column(name = "user_id")
    private Long id;

    
    private int age;

    @Column(length = 30)
    private String name;

}
