package com.tek.interview.question.refactored.vo;

/**
 * Represents an item, contains a price and a description.
 *
 */
public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
}