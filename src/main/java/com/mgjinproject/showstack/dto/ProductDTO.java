package com.mgjinproject.showstack.dto;

import com.mgjinproject.showstack.entity.ProductEntity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {
    
    @NotNull
    private String productId;
    
    @NotNull
    private String productName;

    @NotNull
    @Min(value=500)
    @Max(value=50000)
    private int productPrice;

    @NotNull
    @Min(value=0)
    @Max(value=9999)
    private int productStock;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
    }
}
