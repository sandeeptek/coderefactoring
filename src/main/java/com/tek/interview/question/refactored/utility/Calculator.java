package com.tek.interview.question.refactored.utility;

import java.text.DecimalFormat;
import java.util.Map;

import com.tek.interview.question.refactored.vo.Order;

public class Calculator {

	// Bug - This method was not returning correct value
	public static double rounding(double value) {
		DecimalFormat format = new DecimalFormat("#.##");      
		value = Double.valueOf(format.format(value));
		return value;
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> orderMap) {

		double grandTotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> orderEntry : orderMap.entrySet()) {
			System.out.println("*******" + orderEntry.getKey() + "*******");
			// Bug - Should not be assigned to zero every time
			// grandtotal = 0;

			Order order = orderEntry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			// Bug - Getting IndexOutOfBoundsException here
			for (int i = 0; i < order.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				// Bug - convert to lower case, before checking
				if (order.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = rounding(order.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = rounding(order.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				// Bug - Use rounding method to get correct value
				double totalprice = order.get(i).getItem().getPrice() + rounding(tax);

				// Print out the item's total price
				// Bug - Print the order quantity
				// Bug - Use rounding method to get correct value
				StringBuilder sb = new StringBuilder("");
				sb.append(order.get(i).getQuantity());
				sb.append(" ");
				sb.append(order.get(i).getItem().getDescription());
				sb.append(": ");
				sb.append(rounding(totalprice));
				System.out.println(sb);

				// Keep a running total
				totalTax += tax;
				total += order.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			// Bug - use rounding method to get correct value
			System.out.println("Sales Tax: " + rounding(totalTax));

			// Bug - Remove this line
			// total = total + totalTax;

			// Print out the total amount
			// Bug - use rounding method to get correct value
			System.out.println("Total: " + rounding(total));
			grandTotal += total;
		}
		// Bug - use rounding method to get correct value
		System.out.println("Sum of orders: " + rounding(grandTotal));
	}
}