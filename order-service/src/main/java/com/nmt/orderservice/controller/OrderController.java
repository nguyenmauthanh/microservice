package com.nmt.orderservice.controller;

import com.nmt.orderservice.dto.OrderRequest;
import com.nmt.orderservice.service.OrderService;
import com.nmt.orderservice.validation.OrderValidation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @PostMapping(value = "/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest){
        LOGGER.info("Server received request for create order: {}", orderRequest.toString());

        String invalidData = new OrderValidation().validateCreateOrder(orderRequest);
        if(invalidData == null){
            return new ResponseEntity<>("Thông tin đơn hàng không hợp lệ", HttpStatus.BAD_REQUEST);
        } else {
            orderService.createOrder(orderRequest);
            return new ResponseEntity<>("Đơn hàng được tạo thành công", HttpStatus.OK);
        }
    }
}
