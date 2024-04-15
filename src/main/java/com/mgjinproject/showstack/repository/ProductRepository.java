package com.mgjinproject.showstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgjinproject.showstack.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,String>{

}
