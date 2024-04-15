package com.mgjinproject.showstack.entity;

import com.mgjinproject.showstack.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product")
public class ProductEntity {
    @Id
    String productId;

    String productName;

    Integer productPrice;

    Integer productStock;

    public ProductDTO toDTO(){
        return ProductDTO.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
    }
}
