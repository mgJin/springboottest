package com.mgjinproject.showstack.service.impl;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mgjinproject.showstack.dto.MemberDTO;
import com.mgjinproject.showstack.service.RestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestTemplateServiceImpl implements RestTemplateService{

    @Override
    public String getAroundHub(){
        URI uri = 
            UriComponentsBuilder.fromUriString("http://localhost:8080")
            .path("/api/server/around-hub")
            .encode()
            .build()
            .toUri();

        RestTemplate restTemplate = new RestTemplate();
        //body type 을 String으로 지정
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        log.info("status code : {}",responseEntity.getStatusCode());
        log.info("body : {}", responseEntity.getBody());
        return responseEntity.getBody();

    }
    @Override
  public String getName() {

    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/name")
            .queryParam("name", "Flature")
            .encode()
            .build()
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    log.info("status code : {}",responseEntity.getStatusCode());
    log.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public String getName2() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/path-variable/{name}")
            .encode()
            .build()
            .expand("Flature") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    log.info("status code : {}",responseEntity.getStatusCode());
        log.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public ResponseEntity<MemberDTO> postDTO() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/member")
            .queryParam("name", "Flature")
            .queryParam("email", "jjj@jjj.com")
            .queryParam("organization", "Around Hub Studio")
            .encode()
            .build()
            .toUri();

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName("flature!!");
    

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberDTO> responseEntity =
        restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

   

    return responseEntity;
  }

  @Override
  public ResponseEntity<MemberDTO> addHeader() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:9090")
            .path("/api/server/add-header")
            .encode()
            .build()
            .toUri();

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName("flature");
    

    RequestEntity<MemberDTO> requestEntity =
        RequestEntity.post(uri).header("around-header", "Around Hub Studio").body(memberDTO);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberDTO> responseEntity =
        restTemplate.exchange(requestEntity, MemberDTO.class);

     log.info("status code : {}",responseEntity.getStatusCode());
    log.info("body : {}", responseEntity.getBody());

    return responseEntity;
  }
}

