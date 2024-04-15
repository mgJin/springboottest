package com.mgjinproject.showstack.handler;

import com.mgjinproject.showstack.entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String ProductId);
}
