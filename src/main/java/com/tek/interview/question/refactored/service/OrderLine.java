package com.tek.interview.question.refactored.service;

import com.tek.interview.question.refactored.vo.Item;

/**
 * Represents an order line which contains the @link Item and the quantity.
 *
 */
public class OrderLine {

	private int quantity;
	private Item item;

	/*
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		if (item == null) {
			//System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		// Bug - values are not assigned properly to object variables
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}