package com.dduongdev;

import com.dduongdev.entities.Order;
import com.dduongdev.entities.PaymentMethodEnum;
import com.dduongdev.entities.SalesChannelEnum;
import com.dduongdev.services.OrderService;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(SalesChannelEnum.ONLINE, PaymentMethodEnum.CREDIT_CARD, 500.0);
        OrderService.processOrder(order1);
        System.out.println();
        
        Order order2 = new Order(SalesChannelEnum.IN_STORE, PaymentMethodEnum.COD, 250.0);
        OrderService.processOrder(order2);
        System.out.println();
        
        Order order3 = new Order(SalesChannelEnum.MOBILE_APP, PaymentMethodEnum.E_WALLET, 1000.0);
        OrderService.processOrder(order3);
    }
}

