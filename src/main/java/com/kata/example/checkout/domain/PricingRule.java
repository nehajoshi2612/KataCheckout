package com.kata.example.checkout.domain;

import com.kata.example.checkout.exception.KataPricingRuleException;

public class PricingRule {

	String item;
	double unitPrice;
	int discountUnit;
	double discountPrice;
	
	public PricingRule(String[] ruleParameters) throws KataPricingRuleException {
		if(ruleParameters.length != 4){
			throw new KataPricingRuleException("PricingRule should have 4 paramters separated by delimiter ':'");
		}
		
		try{
		this.item = ruleParameters[0].trim();
		this.unitPrice = Double.parseDouble(ruleParameters[1].trim());
		this.discountUnit = Integer.parseInt(ruleParameters[2].trim());
		this.discountPrice = Double.parseDouble(ruleParameters[3].trim());
		}catch(Exception e){
			throw new KataPricingRuleException(String.format("Invalid format of pricing rule : %s", e.getMessage()));
		}
	}

	public String getItem() {
		return item;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getDiscountUnit() {
		return discountUnit;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

}
