package com.kata.example.checkout;

import com.kata.example.checkout.domain.PricingRule;

@FunctionalInterface
public interface PricingRuleEngine {
	
	public abstract double evaluatePricingRule(PricingRule pr, int itemUnit);
	
}
