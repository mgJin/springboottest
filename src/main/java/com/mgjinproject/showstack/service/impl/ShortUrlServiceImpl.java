package com.mgjinproject.showstack.service.impl;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mgjinproject.showstack.dao.ShortUrlDAO;
import com.mgjinproject.showstack.dto.NaverUriDTO;
import com.mgjinproject.showstack.dto.ShortUrlResponseDTO;
import com.mgjinproject.showstack.entity.ShortUrlEntity;
import com.mgjinproject.showstack.service.ShortUrlService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShortUrlServiceImpl implements ShortUrlService{

    private final ShortUrlDAO shortUrlDAO;

    public ShortUrlServiceImpl(ShortUrlDAO shortUrlDAO){
        this.shortUrlDAO = shortUrlDAO;
    }
    @Override
    public ShortUrlResponseDTO generateShortUrl(String clientId, String clientSecret,String originalUrl){
        log.info("[generateShortUrl] request data : {}",originalUrl);

        ResponseEntity<NaverUriDTO> responseEntity = requestShortUrl(clientId,clientSecret,originalUrl);
        
        String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
        String shortUrl = responseEntity.getBody().getResult().getUrl();
        String hash = responseEntity.getBody().getResult().getHash();

        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setOrgUrl(orgUrl);
        shortUrlEntity.setHash(hash);
        shortUrlEntity.setUrl(shortUrl);

        shortUrlDAO.saveShortUrl(shortUrlEntity);

        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO(orgUrl,shortUrl);
        log.info("[generateShortUrl] ResponseDTO: {}",shortUrlResponseDTO.toString());
        return shortUrlResponseDTO;
    }

    @Override
    public ShortUrlResponseDTO getShortUrl(String clientId, String clientSecret,String originalUrl){
        ShortUrlEntity shortUrlEntity=shortUrlDAO.getShortUrl(originalUrl);
        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO();
        shortUrlResponseDTO.setShortUrl(shortUrlEntity.getUrl());
        return shortUrlResponseDTO;
    }
    
    public ShortUrlResponseDTO getOrgUrl(String clientId, String clientSecret,String shortUrl){
        shortUrlDAO.getOriginalUrl(shortUrl);
        ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO();
        return shortUrlResponseDTO;
    }

    private ResponseEntity<NaverUriDTO> requestShortUrl(String clientId, String clientSecret,String originalUrl){
        log.info("[requestShortUrl] :: clientId: **, clientSecret: ***, originalUrl: {}",
        originalUrl);

        URI uri = UriComponentsBuilder
        .fromUriString("https://openapi.naver.com")
        .path("/v1/util/shorturl")
        .queryParam("url",originalUrl)
        .encode()
        .build()
        .toUri();

        log.info("[requestShortUrl] set Http Request Header");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id",clientId);
        headers.set("X-Naver-Client-Secret",clientSecret);
        
        //body 와 header를 조합해줌
        HttpEntity<String> entity = new HttpEntity<>("",headers);
        RestTemplate restTemplate = new RestTemplate();

        //Uri 와 method를 정하고 request 를 넣은 다음 맨 마지막 response를 어떤 형식으로 받을 건지
        ResponseEntity<NaverUriDTO> responseEntity = restTemplate.exchange(uri,HttpMethod.GET,entity,NaverUriDTO.class);
        log.info("[requestShortUrl] request complete");
        return responseEntity;
    }
}
