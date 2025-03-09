package com.dduongdev.services;

import com.dduongdev.entities.Order;
import com.dduongdev.factories.OrderProcessingFactory;
import com.dduongdev.factories.PaymentProcessingFactory;
import com.dduongdev.factories.ShippingCostFactory;
import com.dduongdev.payments.IPaymentProcessor;
import com.dduongdev.processors.IOrderProcessor;
import com.dduongdev.shippings.IShippingCalculator;

public class OrderService {
    public static void processOrder(Order order) {
        IOrderProcessor processor = OrderProcessingFactory.createOrderProcessor(order.getSalesChannel());
        IPaymentProcessor paymentProcessor = PaymentProcessingFactory.createPaymentProcessor(order.getPaymentMethod());
        IShippingCalculator shippingCalculator = ShippingCostFactory.createShippingCalculator(order.getSalesChannel());

        processor.process(order);
        paymentProcessor.process(order);
        double shippingCost = shippingCalculator.calculate(order);
        System.out.println("Shipping cost: " + shippingCost);
    }
}
