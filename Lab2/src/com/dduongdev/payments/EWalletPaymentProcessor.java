package com.dduongdev.payments;

import com.dduongdev.entities.Order;

public class EWalletPaymentProcessor implements IPaymentProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing e-wallet payment for order: " + order);
    }
}