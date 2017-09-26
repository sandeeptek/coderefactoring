package com.tek.interview.question;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.refactored.service.OrderLine;
import com.tek.interview.question.refactored.utility.Calculator;
import com.tek.interview.question.refactored.vo.Item;
import com.tek.interview.question.refactored.vo.Order;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}

	@Test
	public void testRoundingMethod() {
		assertThat(Calculator.rounding(12.487), is(12.49));
		assertThat(Calculator.rounding(14.986), is(14.99));
		assertThat(Calculator.rounding(0.854), is(0.85));
	}

	/**
	 * Added this to improve code coverage
	 * @throws Exception
	 */
	@Test
	public void testCalculateMethod() throws Exception {

		Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

		Order order = new Order();

		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orderMap.put("Order 1", order);
		
		order = new Order();

		order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		orderMap.put("Order 2", order);
		
		calculator.calculate(orderMap);
	}
}