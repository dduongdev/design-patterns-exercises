package com.dduongdev.payments;

import com.dduongdev.entities.Order;

public class CreditCardPaymentProcessor implements IPaymentProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing credit card payment for order: " + order);
    }
}
