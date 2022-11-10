package com.example.DrServer.SocialLogin;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자 만들어 줌
@DynamicUpdate//update할 때 실제 값이 변경됨
@Entity //JPA Entity 임을 명시
@Table(name = "kakao_user")
//@Data
//@AllArgsConstructor
public class KakaoEntity {
//    public KakaoEntity(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ka_id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "nickname", nullable = true, unique = true)
    private String nickname;

    @Builder //생성을 Builder 패턴으로 하기 위해서
    public KakaoEntity(String id, String name, String email, String provider, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.nickname = nickname;
    }


    public KakaoEntity update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}