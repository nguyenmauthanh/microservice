package com.nmt.orderservice.service.impl;

import com.nmt.orderservice.dto.OrderRequest;
import com.nmt.orderservice.repository.OrderRepository;
import com.nmt.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderRequest orderRequest) {

    }
}
