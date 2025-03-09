package com.dduongdev.shippings;

import com.dduongdev.entities.Order;

public class MobileAppShippingCalculator implements IShippingCalculator {
    @Override
    public double calculate(Order order) {
        return 5.0;
    }
}