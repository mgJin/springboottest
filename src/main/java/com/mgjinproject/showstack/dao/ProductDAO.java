package com.mgjinproject.showstack.dao;

import com.mgjinproject.showstack.entity.ProductEntity;

public interface ProductDAO {
    
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
}
