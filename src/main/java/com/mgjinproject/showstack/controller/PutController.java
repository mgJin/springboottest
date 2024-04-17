package com.mgjinproject.showstack.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mgjinproject.showstack.dto.ArticleDTO;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    
    @PutMapping("/default")
    public String putMethodName() { 
        return "Hello Put";
    }
    @PutMapping("/json")
    public String putPut(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }

    @PutMapping("/default3")
    public ResponseEntity<ArticleDTO> postArticleDTO(@RequestBody ArticleDTO articleDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(articleDTO);
    }
}
