package com.dduongdev.entities;

public class Order {
	private SalesChannelEnum salesChannel;
	private PaymentMethodEnum paymentMethod;
	private double totalAmount;

	public Order(SalesChannelEnum salesChannel, PaymentMethodEnum paymentMethod, double totalAmount) {
		super();
		this.salesChannel = salesChannel;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
	}

	public SalesChannelEnum getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(SalesChannelEnum salesChannel) {
		this.salesChannel = salesChannel;
	}

	public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [salesChannel=" + salesChannel + ", paymentMethod=" + paymentMethod + ", totalAmount="
				+ totalAmount + "]";
	}

}
