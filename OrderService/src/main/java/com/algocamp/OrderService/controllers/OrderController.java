package com.algocamp.OrderService.controllers;

import com.algocamp.OrderService.dto.CreateOrderResponseDTO;
import com.algocamp.OrderService.dto.OrderRequestDTO;
import com.algocamp.OrderService.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){
        CreateOrderResponseDTO order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }
}







