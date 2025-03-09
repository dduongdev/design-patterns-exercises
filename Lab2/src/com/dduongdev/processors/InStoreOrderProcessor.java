package com.dduongdev.processors;

import com.dduongdev.entities.Order;

public class InStoreOrderProcessor implements IOrderProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing in-store order: " + order);
    }
}
