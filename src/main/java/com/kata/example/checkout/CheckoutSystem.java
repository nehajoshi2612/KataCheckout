package com.kata.example.checkout;

import com.kata.example.checkout.exception.KataCheckoutException;
import com.kata.example.checkout.exception.KataPricingRuleException;

/**
 * Main class for checkout
 * @author Neha
 *
 */
public class CheckoutSystem {
	
	private CheckoutScanner checkoutScanner;
	private PriceCalculator priceCalculator;
	
	public CheckoutSystem(){
		checkoutScanner = new CheckoutScanner();
		priceCalculator = new PriceCalculator();
	}
	
	public static void main(String[] args) throws KataCheckoutException, KataPricingRuleException {
		
		//initializeTheSystem - read Data
		CheckoutSystem checkoutSystem = new CheckoutSystem();
		checkoutSystem.checkoutScanner.readData();
		
		//CalculatePrice
		Double totalPrice = checkoutSystem.priceCalculator.calculateTotalPrice(checkoutSystem.checkoutScanner);
		
		//Print the total
		System.out.println(String.format("Total Amount to be paid is : $%4.2f", totalPrice));
	}
}
