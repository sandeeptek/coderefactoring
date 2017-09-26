package com.tek.interview.question;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.refactored.service.OrderLine;
import com.tek.interview.question.refactored.vo.Item;
import com.tek.interview.question.refactored.vo.Order;

public class OrderTest {

	private Order order;

	@Before
	public void init() {
		order = new Order();
	}

	@Test
	public void testAddAndClearMethods() throws Exception {
		order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		assertThat(2, is(order.size()));
		order.clear();
		assertThat(0, is(order.size()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithNullOrderLine() throws Exception {
		order.add(null);
	}

	@Test(expected = Exception.class)
	public void testWithNullItem() throws Exception {
		new OrderLine(null, 1);
	}

	@Test(expected = AssertionError.class)
	public void testAddWithNegativeQuantity() throws Exception {
		new OrderLine(new Item("book", 47.50f), -1);
	}

	@Test
	public void testVOs() throws Exception {
		Item item1 = new Item("imported box of chocolate", 10);
		Item item2 = new Item("imported bottle of perfume", (float) 47.50);

		OrderLine orderLine1 = new OrderLine(item1, 1);
		OrderLine orderLine2 = new OrderLine(item2, 2);

		order.add(orderLine1);
		order.add(orderLine2);

		assertThat(orderLine1, is(order.get(0)));
		assertThat(orderLine2, is(order.get(1)));

		assertThat(1, is(order.get(0).getQuantity()));
		assertThat(2, is(order.get(1).getQuantity()));

		assertThat(item1, is(order.get(0).getItem()));
		assertThat(item2, is(order.get(1).getItem()));

		assertThat(10.00f, is(order.get(0).getItem().getPrice()));
		assertThat(47.50f, is(order.get(1).getItem().getPrice()));

		assertThat("imported box of chocolate", is(order.get(0).getItem().getDescription()));
		assertThat("imported bottle of perfume", is(order.get(1).getItem().getDescription()));

	}
}