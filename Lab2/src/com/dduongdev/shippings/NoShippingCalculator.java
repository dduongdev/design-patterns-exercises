package com.dduongdev.shippings;

import com.dduongdev.entities.Order;

public class NoShippingCalculator implements IShippingCalculator {
	@Override
    public double calculate(Order order) {
        return 0.0; 
    }
}
