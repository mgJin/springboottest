package com.mgjinproject.showstack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgjinproject.showstack.dao.ProductDAO;
import com.mgjinproject.showstack.entity.ProductEntity;
import com.mgjinproject.showstack.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO{
    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId){
        ProductEntity productEntity = productRepository.getReferenceById(productId);
        return productEntity;
    }
}
