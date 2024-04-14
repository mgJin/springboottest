package com.mgjinproject.showstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mgjinproject.showstack.entity.Article;


public interface ArticleRepository extends JpaRepository<Article,Long>{
    
}
