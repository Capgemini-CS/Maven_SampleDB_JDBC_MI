package com.capgemini.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class OrderDetailDTO {

    @Getter @Setter private int orderNumber;
    @Getter @Setter private String productCode;
    @Getter @Setter private int quantityOrdered;
    @Getter @Setter private double priceEach;
    @Getter @Setter private int orderLineNumber;

    public OrderDetailDTO() {}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDetail{");
        sb.append("orderNumber=").append(orderNumber);
        sb.append(", productCode='").append(productCode).append('\'');
        sb.append(", quantityOrdered=").append(quantityOrdered);
        sb.append(", priceEach=").append(priceEach);
        sb.append(", orderLineNumber=").append(orderLineNumber);
        sb.append('}');
        return sb.toString();
    }
}
