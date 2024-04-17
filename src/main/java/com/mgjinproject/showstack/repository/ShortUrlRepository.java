package com.mgjinproject.showstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgjinproject.showstack.entity.ShortUrlEntity;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

    //쿼리를 따로 만들지 않아도 생성을 해준다.(findby 라고 하면 알아서 넣어줌)
    
    ShortUrlEntity findByUrl(String url);
    ShortUrlEntity findByOrgUrl(String originalUrl);
}
