package com.mgjinproject.showstack.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgjinproject.showstack.dto.ArticleForm;
import com.mgjinproject.showstack.entity.Article;
import com.mgjinproject.showstack.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/api/v1")
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    
    @GetMapping("/articles/formtest")
    public String newArticleForm(){
        return "articles/formtest";
    }

    @GetMapping(value="/articles/good/{variable}")
    public String getGood(@PathVariable String variable){
        return variable;
    }
    @GetMapping(value="/articles/goods/{variable}")
    public String getGoods(@PathVariable("variable") String va){
        return va;
    }
    @GetMapping(value="/aritcles/bad")
    public String getBad(
        @RequestParam String name,
        @RequestParam int age) {
        return name + age;
    }
    @PostMapping("/article/test")
    public String posttest() {
       
        
        return "Hello world";
    }
    
    @PostMapping("/article/new")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }
    
    

    
    @PostMapping("articles/create")
    public String createArticle(ArticleForm form){
        log.info("{}, product",form.toString());
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article.toString());
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";
    }
}
