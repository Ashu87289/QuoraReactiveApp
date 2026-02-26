package com.algocamp.OrderService.service;


import com.algocamp.OrderService.dto.CreateOrderResponseDTO;
import com.algocamp.OrderService.dto.OrderRequestDTO;
import org.springframework.stereotype.Service;


public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO);
}
