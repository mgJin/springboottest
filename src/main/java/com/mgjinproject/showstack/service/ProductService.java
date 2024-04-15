package com.mgjinproject.showstack.service;

import com.mgjinproject.showstack.dto.ProductDTO;

public interface ProductService {

    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);
    
    ProductDTO getProduct(String productId);
}
