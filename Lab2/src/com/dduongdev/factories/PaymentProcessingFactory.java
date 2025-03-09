package com.dduongdev.factories;

import com.dduongdev.entities.PaymentMethodEnum;
import com.dduongdev.payments.CODPaymentProcessor;
import com.dduongdev.payments.CreditCardPaymentProcessor;
import com.dduongdev.payments.EWalletPaymentProcessor;
import com.dduongdev.payments.IPaymentProcessor;

public class PaymentProcessingFactory {
    public static IPaymentProcessor createPaymentProcessor(PaymentMethodEnum method) {
        switch (method) {
            case COD:
                return new CODPaymentProcessor();
            case CREDIT_CARD:
                return new CreditCardPaymentProcessor();
            case E_WALLET:
                return new EWalletPaymentProcessor();
            default:
                throw new IllegalArgumentException("Unsupported payment method");
        }
    }
}
