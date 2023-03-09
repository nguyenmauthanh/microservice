package com.nmt.orderservice.service;

import com.nmt.orderservice.dto.OrderRequest;

public interface OrderService {
    void createOrder(OrderRequest orderRequest);
}
