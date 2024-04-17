package com.mgjinproject.showstack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mgjinproject.showstack.dao.ShortUrlDAO;
import com.mgjinproject.showstack.entity.ShortUrlEntity;
import com.mgjinproject.showstack.repository.ShortUrlRepository;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO{

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity){
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.save(shortUrlEntity);
        return foundShortUrlEntity;
    }
    @Override
    public ShortUrlEntity getShortUrl(String originalUrl){
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrlEntity;
    }
    @Override
    public ShortUrlEntity getOriginalUrl(String shortUrl){
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        return foundShortUrlEntity;
    }

    //삭제는 url로 find 해서 entity를 반환받고 그것을 이용해서 다시 레포에 엔티티를 넣어서 딜리트 요청
}
