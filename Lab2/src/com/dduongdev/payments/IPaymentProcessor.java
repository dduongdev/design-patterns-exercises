package com.dduongdev.payments;

import com.dduongdev.entities.Order;

public interface IPaymentProcessor {
    void process(Order order);
}
