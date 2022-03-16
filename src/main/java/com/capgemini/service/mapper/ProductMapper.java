package com.capgemini.service.mapper;

import com.capgemini.model.Product;
import com.capgemini.service.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO fromProductToProductDTO (Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode(product.getProductCode());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductLine(product.getProductLine());
        productDTO.setProductScale(product.getProductScale());
        productDTO.setProductVendor(product.getProductVendor());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setQuantityInStock(product.getQuantityInStock());
        productDTO.setBuyPrice(product.getBuyPrice());
        return productDTO;
    }

    public static Product fromProductDtoTOProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setProductCode(productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        product.setProductLine(productDTO.getProductLine());
        product.setProductScale(productDTO.getProductScale());
        product.setProductVendor(productDTO.getProductVendor());
        product.setProductDescription(productDTO.getProductDescription());
        product.setQuantityInStock(productDTO.getQuantityInStock());
        product.setBuyPrice(productDTO.getBuyPrice());
        return product;
    }
}
