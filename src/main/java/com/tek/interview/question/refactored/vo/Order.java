package com.tek.interview.question.refactored.vo;

import java.util.ArrayList;
import java.util.List;

import com.tek.interview.question.refactored.service.OrderLine;

/**
 * Represents an order, contains orderLines.
 *
 */
public class Order {

	private List<OrderLine> orderLines;

	// Bug - null pointer exception here
	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			//System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}