package com.tek.interview.question.refactored;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tek.interview.question.refactored.service.OrderLine;
import com.tek.interview.question.refactored.utility.Calculator;
import com.tek.interview.question.refactored.vo.Item;
import com.tek.interview.question.refactored.vo.Order;

/* ****************************************************************************************
 
Please remove all bugs from the code below to get the following output:

<pre>

*******Order 1*******
1 book: 13.74
1 music CD: 16.49
1 chocolate bar: 0.94
Sales Tax: 2.84
Total: 28.33
*******Order 2*******
1 imported box of chocolate: 11.5
1 imported bottle of perfume: 54.62
Sales Tax: 8.62
Total: 57.5
*******Order 3*******
1 Imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 10.73
1 box of imported chocolates: 12.94
Sales Tax: 8.77
Total: 67.98
Sum of orders: 153.81
 
</pre>
 
******************************************************************************************** */

public class Foo {

	public static void main(String[] args) throws Exception {

		// Bug - Maintain the order of insertion
		Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

		Order order = new Order();

		// Bug - This variable is not used locally.
		// double grandTotal = 0;

		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orderMap.put("Order 1", order);

		// Reuse cart for an other order
		// Bug - we are removing the orders from collection, instead of that we have to create new order.
		// c.clear();
		order = new Order();

		order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		orderMap.put("Order 2", order);

		// Reuse cart for an other order
		// c.clear();
		// Bug - we are removing the orders from collection, instead of that we have to create new order.
		order = new Order();
		
		order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		order.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		order.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		// Bug - corrected importd to imported
		order.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		orderMap.put("Order 3", order);

		new Calculator().calculate(orderMap);

	}
}