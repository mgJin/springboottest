package com.mgjinproject.showstack.service;

import com.mgjinproject.showstack.dto.ShortUrlResponseDTO;

public interface ShortUrlService {
    ShortUrlResponseDTO getShortUrl(String clientId, String clientSecret,String originalUrl);
    ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret,String originalUrl);
    
}
