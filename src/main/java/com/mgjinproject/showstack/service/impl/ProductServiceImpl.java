package com.mgjinproject.showstack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgjinproject.showstack.dto.ProductDTO;
import com.mgjinproject.showstack.entity.ProductEntity;
import com.mgjinproject.showstack.handler.ProductDataHandler;
import com.mgjinproject.showstack.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
 
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock){
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDTO productDTO = new ProductDTO(
            productEntity.getProductId(),
            productEntity.getProductName(),
            productEntity.getProductPrice(),
            productEntity.getProductStock()
        );
        return productDTO;
    }

    @Override
    public ProductDTO getProduct(String productId){
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDTO productDTO = new ProductDTO(
            productEntity.getProductId(),
            productEntity.getProductName(),
            productEntity.getProductPrice(),
            productEntity.getProductStock()
        );
        return productDTO;
    }
}
