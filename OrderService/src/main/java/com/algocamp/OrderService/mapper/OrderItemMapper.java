package com.algocamp.OrderService.mapper;

import com.algocamp.OrderService.dto.OrderItemDTO;
import com.algocamp.OrderService.entity.OrderEntity;
import com.algocamp.OrderService.entity.OrderItems;

public class OrderItemMapper {

    public static OrderItems OrderItemRequestDTOtoOrderItemEntity(OrderItemDTO itemDTO, OrderEntity order, double pricePerUnit,double totalPrice){
        return OrderItems.builder()
                .productId(itemDTO.getProductId())
                .quantity(itemDTO.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
