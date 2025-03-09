package com.dduongdev.shippings;

import com.dduongdev.entities.Order;

public class OnlineShippingCalculator implements IShippingCalculator {
    @Override
    public double calculate(Order order) {
        return 10.0; 
    }
}
