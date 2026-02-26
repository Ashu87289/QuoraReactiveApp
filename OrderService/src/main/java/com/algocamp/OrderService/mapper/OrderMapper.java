package com.algocamp.OrderService.mapper;

import com.algocamp.OrderService.dto.CreateOrderResponseDTO;
import com.algocamp.OrderService.dto.OrderRequestDTO;
import com.algocamp.OrderService.entity.OrderEntity;
import com.algocamp.OrderService.enums.OrderStatus;

public class OrderMapper {

    public  static OrderEntity toEntity(OrderRequestDTO dto){
        return OrderEntity.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(OrderEntity  order){
        return CreateOrderResponseDTO.builder()
                .orderId(order.getUserId())
                .status(order.getStatus())
                .build();
    }
}
