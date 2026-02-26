package com.algocamp.OrderService.service.Impl;

import com.algocamp.OrderService.client.ProductServiceClient;
import com.algocamp.OrderService.dto.CreateOrderResponseDTO;
import com.algocamp.OrderService.dto.OrderItemDTO;
import com.algocamp.OrderService.dto.OrderRequestDTO;
import com.algocamp.OrderService.dto.ProductDTO;
import com.algocamp.OrderService.entity.OrderEntity;
import com.algocamp.OrderService.entity.OrderItems;
import com.algocamp.OrderService.mapper.OrderItemMapper;
import com.algocamp.OrderService.mapper.OrderMapper;
import com.algocamp.OrderService.repository.OrderRepository;
import com.algocamp.OrderService.service.IOrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productClient){
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    @Transactional
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {
        //Persist The order in order table. > OrderRequestDTO > Order Entity

        // 1. Create Order entity (NOT saved yet)
        OrderEntity order = OrderMapper.toEntity(request);
        order = orderRepository.save(order);

        List<OrderItems> items = new ArrayList<>();
        // 2. Build order items
        for(OrderItemDTO itemDTO : request.getOrderItems()){
            //fetch the product details for every item.
            ProductDTO productDTO = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = productDTO.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItems item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );

         items.add(item);
        }
        // 3. Attach items to order
        order.setItems(items);

        // 4. Save ONCE (Cascade saves items)
        OrderEntity savedOrder = orderRepository.save(order);

        // 5. Return response
        return OrderMapper.toCreateOrderResponseDTO(savedOrder);
    }
}
