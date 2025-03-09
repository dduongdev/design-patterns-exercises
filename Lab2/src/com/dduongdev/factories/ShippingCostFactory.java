package com.dduongdev.factories;

import com.dduongdev.entities.SalesChannelEnum;
import com.dduongdev.shippings.IShippingCalculator;
import com.dduongdev.shippings.MobileAppShippingCalculator;
import com.dduongdev.shippings.NoShippingCalculator;
import com.dduongdev.shippings.OnlineShippingCalculator;

public class ShippingCostFactory {
    public static IShippingCalculator createShippingCalculator(SalesChannelEnum channel) {
        switch (channel) {
            case ONLINE:
                return new OnlineShippingCalculator();
            case IN_STORE:
                return new NoShippingCalculator();
            case MOBILE_APP:
                return new MobileAppShippingCalculator();
            default:
                throw new IllegalArgumentException("Unsupported sales channel");
        }
    }
}
