package com.kata.example.checkout;

import java.util.HashMap;
import java.util.Map;

import com.kata.example.checkout.domain.ItemAtCheckout;
import com.kata.example.checkout.domain.PricingRule;

/***
 * This class is responsible to evaluate price of all the scanned products and also sum up to find the total price. 
 * @author Neha Joshi
 *
 */
public class PriceCalculator {
	
	private Map<String, ItemAtCheckout> itemPriceMap = new HashMap<String, ItemAtCheckout>();
	
	/***
	 * Implementation of the pricingruleengine interface
	 */
	PricingRuleEngine unitPricing= (p, itemCount) -> {
			return p.getUnitPrice() * itemCount;
	};
		
	PricingRuleEngine discountPricingRule= (p, itemCount) -> {
		if(p.getDiscountUnit() == 0){ //Scenario if there is no discount just calculate based on unitPrice
			return unitPricing.evaluatePricingRule(p, itemCount);
		}
		int discountItemCount = itemCount / p.getDiscountUnit();
		int remainderItemCount = itemCount % p.getDiscountUnit();
        return discountItemCount * p.getDiscountPrice() +  unitPricing.evaluatePricingRule(p, remainderItemCount);
	};
	
	/**
	 * 
	 * @param item : Item to calculate
	 * @param pr : Pricing rule of the item
	 */
	private void calculatePriceOfItem(String item, PricingRule pr){
		
		if(itemPriceMap.containsKey(item)){
			ItemAtCheckout iac = itemPriceMap.get(item);
			iac.setUnit(iac.getUnit() + 1);
			iac.setPrice(discountPricingRule.evaluatePricingRule(pr, iac.getUnit()));
			itemPriceMap.replace(item, iac);
			
		}else{
			itemPriceMap.put(item, new ItemAtCheckout(item, 1, unitPricing.evaluatePricingRule(pr, 1))); 	
		}
	}

	/***
	 * 
	 * @param checkoutScanner : object that has pricingrules and items to be priced
	 * @return total cost
	 */
	public double calculateTotalPrice(CheckoutScanner checkoutScanner) {
		
		for(String item: checkoutScanner.getItemsAtCheckout()){
			calculatePriceOfItem(item, checkoutScanner.getPricingRuleByItem(item));
		}
		
		//Use of streams to sum up
		return itemPriceMap.values().parallelStream().reduce(0.0, (output, item) -> output + item.getPrice(), (a, b) -> a + b); 
	}

}
