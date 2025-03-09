package com.dduongdev.shippings;

import com.dduongdev.entities.Order;

public interface IShippingCalculator {
    double calculate(Order order);
}

