package com.kata.example.checkout.domain;

public class ItemAtCheckout {

	private String item;
	private int unit;
	private double price;
	
	
	public ItemAtCheckout(String item, int unit, double price) {
		super();
		this.item = item;
		this.unit = unit;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemAtCheckout [item=" + item + ", unit=" + unit + ", price=" + price + "]";
	}
	
	
	
}
