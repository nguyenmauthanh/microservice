package com.nmt.orderservice.validation;

import com.nmt.orderservice.dto.OrderRequest;
import com.nmt.orderservice.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderValidation extends AbstractValidation{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderValidation.class);

    public String validateCreateOrder(OrderRequest orderRequest) throws ValidationException {
        if(orderRequest == null){
            return "Payload không hợp lệ";
        }

        if(orderRequest.getOrderLineItemsDtoList() == null){
            getMessageDes().add("Đơn hàng không được trống");
        }

        return !isValid() ? this.buildValidationMessage() : null;
    }

}
