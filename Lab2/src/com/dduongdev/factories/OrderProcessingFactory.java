package com.dduongdev.factories;

import com.dduongdev.entities.SalesChannelEnum;
import com.dduongdev.processors.IOrderProcessor;
import com.dduongdev.processors.InStoreOrderProcessor;
import com.dduongdev.processors.MobileAppOrderProcessor;
import com.dduongdev.processors.OnlineOrderProcessor;

public class OrderProcessingFactory {
    public static IOrderProcessor createOrderProcessor(SalesChannelEnum channel) {
        switch (channel) {
            case ONLINE:
                return new OnlineOrderProcessor();
            case IN_STORE:
                return new InStoreOrderProcessor();
            case MOBILE_APP:
                return new MobileAppOrderProcessor();
            default:
                throw new IllegalArgumentException("Unsupported sales channel");
        }
    }
}
