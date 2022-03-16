package com.capgemini.service.mapper;

import com.capgemini.model.OrderDetail;
import com.capgemini.service.dto.OrderDetailDTO;

public class OrderDetailsMapper {
    public static OrderDetailDTO fromOrderDetailToOrderDetailDTO(OrderDetail orderDetail){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setOrderNumber(orderDetail.getOrderNumber());
        orderDetailDTO.setProductCode(orderDetail.getProductCode());
        orderDetailDTO.setQuantityOrdered(orderDetail.getQuantityOrdered());
        orderDetailDTO.setPriceEach(orderDetail.getPriceEach());
        orderDetailDTO.setOrderLineNumber(orderDetail.getOrderLineNumber());

        return orderDetailDTO;
    }

    public static OrderDetail fromOrderDetDTOtoOrderDetail( OrderDetailDTO orderDetailDTO){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNumber(orderDetailDTO.getOrderNumber());
        orderDetail.setProductCode(orderDetailDTO.getProductCode());
        orderDetail.setQuantityOrdered(orderDetailDTO.getQuantityOrdered());
        orderDetail.setPriceEach(orderDetailDTO.getPriceEach());
        orderDetail.setOrderLineNumber(orderDetailDTO.getOrderLineNumber());

        return orderDetail;
    }
}
