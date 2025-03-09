package com.dduongdev.processors;

import com.dduongdev.entities.Order;

public class MobileAppOrderProcessor implements IOrderProcessor {
    @Override
    public void process(Order order) {
        System.out.println("Processing mobile app order: " + order);
    }
}