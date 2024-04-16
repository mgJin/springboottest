package com.mgjinproject.showstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgjinproject.showstack.service.impl.ShortUrlServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/short-url")
@Slf4j
public class ShortUrlController {

    @Value("${around.hub.short.url.id}")
    private String CLIENT_ID;

    @Value("${around.hub.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlServiceImpl shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlServiceImpl shortUrlService){
        this.shortUrlService = shortUrlService;
    }

    @PostMapping()
    public ShortUrlResponseDTO generateShortUrl(String originalUrl){
        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl)
    }
}
