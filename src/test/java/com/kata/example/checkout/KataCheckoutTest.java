package com.kata.example.checkout;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.kata.example.checkout.exception.KataCheckoutException;
import com.kata.example.checkout.exception.KataPricingRuleException;

public class KataCheckoutTest {

	@Test
	public void testOneItem() throws KataCheckoutException, KataPricingRuleException{
		ByteArrayInputStream in = new ByteArrayInputStream("A:20:3:10\nEND-PR\nA\nA\nA".getBytes());
		System.setIn(in);
		CheckoutScanner cs = new CheckoutScanner();
		cs.readData();
		PriceCalculator pc = new PriceCalculator();
		assertEquals(10.0, pc.calculateTotalPrice(cs),0.0);
		System.setIn(System.in);
	}
	
	
	@Test
	public void testMultipleItems() throws KataCheckoutException, KataPricingRuleException{
		ByteArrayInputStream in = new ByteArrayInputStream("A:20:3:10\nB:20:2:15\nEND-PR\nA\nB\nB\nB\nA\nA\nA".getBytes());
		System.setIn(in);
		CheckoutScanner cs = new CheckoutScanner();
		cs.readData();
		PriceCalculator pc = new PriceCalculator();
		assertEquals(65.0, pc.calculateTotalPrice(cs),0.0);
		System.setIn(System.in);
	}
	
	@Test
	public void testOneItemWithNoDiscount() throws KataCheckoutException, KataPricingRuleException{
		ByteArrayInputStream in = new ByteArrayInputStream("A:20:0:0\nEND-PR\nA\nA\nA".getBytes());
		System.setIn(in);
		CheckoutScanner cs = new CheckoutScanner();
		cs.readData();
		PriceCalculator pc = new PriceCalculator();
		assertEquals(60.0, pc.calculateTotalPrice(cs),0.0);
		System.setIn(System.in);
	}
	
	//Many scenarios more need to be tested for negative input
}
