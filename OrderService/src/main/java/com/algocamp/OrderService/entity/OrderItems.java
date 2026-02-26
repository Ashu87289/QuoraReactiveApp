package com.algocamp.OrderService.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="order_items")
public class OrderItems extends BaseEntity{

    private Long productId;
    private int quantity;
    private double pricePerUnit;

    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private OrderEntity order;
}
