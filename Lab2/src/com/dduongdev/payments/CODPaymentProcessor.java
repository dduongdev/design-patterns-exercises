package com.dduongdev.payments;

import com.dduongdev.entities.Order;

public class CODPaymentProcessor implements IPaymentProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing COD payment for order: " + order);
    }
}