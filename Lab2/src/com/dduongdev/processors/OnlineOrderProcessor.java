package com.dduongdev.processors;

import com.dduongdev.entities.Order;

public class OnlineOrderProcessor implements IOrderProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing online order: " + order);
    }
}