package com.mgjinproject.showstack.dao;

import com.mgjinproject.showstack.entity.ShortUrlEntity;

public interface ShortUrlDAO {
    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);
    ShortUrlEntity getShortUrl(String originalUrl);
    ShortUrlEntity getOriginalUrl(String shortUrl);
}
