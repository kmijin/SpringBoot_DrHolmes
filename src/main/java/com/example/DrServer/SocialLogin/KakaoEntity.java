package com.example.DrServer.SocialLogin;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)//ê¸°ë³¸ ìì±ì ë§ë¤ì´ ì¤
@DynamicUpdate//updateí  ë ì¤ì  ê°ì´ ë³ê²½ë¨
@Entity //JPA Entity ìì ëªì
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

    @Builder //ìì±ì Builder í¨í´ì¼ë¡ íê¸° ìí´ì
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