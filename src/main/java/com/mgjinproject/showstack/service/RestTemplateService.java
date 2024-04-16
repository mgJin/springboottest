package com.mgjinproject.showstack.service;

import org.springframework.http.ResponseEntity;

import com.mgjinproject.showstack.dto.MemberDTO;


public interface RestTemplateService {
    public String getAroundHub();
    public String getName();
    public String getName2();
    public ResponseEntity<MemberDTO> postDTO();
    public ResponseEntity<MemberDTO> addHeader();
}
