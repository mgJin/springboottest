package com.mgjinproject.showstack.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgjinproject.showstack.dao.ProductDAO;
import com.mgjinproject.showstack.entity.ProductEntity;
import com.mgjinproject.showstack.handler.ProductDataHandler;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock){
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);
        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId){
        return productDAO.getProduct(productId);
    }
}
