package com.capgemini.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ProductDTO {
    @Getter @Setter private String productCode;
    @Getter @Setter private String productName;
    @Getter @Setter private String productLine;
    @Getter @Setter private String productScale;
    @Getter @Setter private String productVendor;
    @Getter @Setter private String productDescription;
    @Getter @Setter private int quantityInStock;
    @Getter @Setter private double buyPrice;

    public ProductDTO() { }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductDTO{");
        sb.append("productCode='").append(productCode).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", productLine='").append(productLine).append('\'');
        sb.append(", quantityInStock=").append(quantityInStock);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append('}');
        return sb.toString();
    }
}
