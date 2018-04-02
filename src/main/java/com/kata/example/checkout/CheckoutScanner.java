package com.kata.example.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kata.example.checkout.domain.PricingRule;
import com.kata.example.checkout.exception.KataCheckoutException;
import com.kata.example.checkout.exception.KataPricingRuleException;

/**
 * 
 * Scanner to read Pricing rules and items
 * This can be improved and should be improved to handle exceptions; improve the user interface 
 * where user can read multiple sets of checkouts but pricing rules only once.
 * Also currently only discountpricingrule is supported but multiple rules should be supported 
 * For example:
 * a. Buy 2 Get 1 Free
 * b. Total checkout of $100 or more will help you reduce price of item 'X' by 10 cents
 * c. etc etc
 * @author Neha
 *
 */
public class CheckoutScanner {
	
	private Map<String, PricingRule> pricingRules = new HashMap<String, PricingRule>();
	private List<String> itemsAtCheckout = new ArrayList<String>();
	
	public void readData() throws KataCheckoutException, KataPricingRuleException{
		  System.out.println(String.format("Welcome to the Kata checkout system. Please enter the pricing rules followed by items to be scanned. \nExample:\n%s\n%s\n%s\n%s", 
				  "Item:UnitPrice:DiscountItem:DiscountPrice(List)", "END-PR", "Item (List)", "END"));
		  
		  try (Scanner scanner = new Scanner(System.in)){
			  	boolean isLinePR = true;
		        while (scanner.hasNextLine()){
		        	String currentLine = scanner.nextLine().trim().toUpperCase();
		        	
		        	if ("END".equalsIgnoreCase(currentLine)) { 
		                scanner.close();
		                break;
		            }
		        	if("END-PR".equalsIgnoreCase(currentLine)){
		        		isLinePR = false;
		        		continue;
		        	}else if(isLinePR){
		        		String[] pr = currentLine.split(":");
		        		PricingRule newPR = new PricingRule(pr);
			        	pricingRules.put(newPR.getItem(),  newPR);
		        	}else{
		        		if(pricingRules.containsKey(currentLine)){
		        			itemsAtCheckout.add(currentLine);
		        		}else{
		        			System.err.println("Item scanned doesn't exist in the system. Please talk to the manager. This item will be skipped.\nPlease remove it from the checkout!");
		        		}	
		        	}
		        }
		    }catch(Exception e){
		    	System.out.println("There was an error while reading data. " + e.getMessage());
		    	throw e;
		 }
	}
	
	
	public PricingRule getPricingRuleByItem(String item){
		return pricingRules.get(item);
	}

	public List<String> getItemsAtCheckout() {
		return itemsAtCheckout;
	}
	
	

}
