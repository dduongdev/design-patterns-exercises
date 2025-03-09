package com.dduongdev.processors;

import com.dduongdev.entities.Order;

public interface IOrderProcessor {
	void process(Order order);
}
