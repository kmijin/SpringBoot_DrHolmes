package com.example.DrServer.SocialLogin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//findByEmailAndProvider 메서드를 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단
public interface KakaoRepo extends JpaRepository<KakaoEntity, Long> {
    Optional<KakaoEntity> findByEmailAndProvider(String email, String provider);
}
