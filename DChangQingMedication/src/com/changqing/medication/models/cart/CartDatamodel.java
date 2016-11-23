package com.changqing.medication.models.cart;

import android.graphics.drawable.Drawable;

public class CartDatamodel {

	public Drawable drawable;
	public Drawable getDrawable() {
		return drawable;
	}
	public CartDatamodel setDrawable(Drawable image) {
		this.drawable = image;
		return this;
	}
	public String getName() {
		return name;
	}
	public CartDatamodel setName(String name) {
		this.name = name;
		return this;
	}
	public String getDesc() {
		return desc;
	}
	public CartDatamodel setDesc(String desc) {
		this.desc = desc;
		return this;
	}
	public float getPrice() {
		return price;
	}
	public CartDatamodel setPrice(float price) {
		this.price = price;
		return this;
	}
	public int getAmount() {
		return amount;
	}
	public CartDatamodel setAmount(int number) {
		this.amount = number;
		return this;
	}
	
	
	public String name;
	public String desc;
	public float price;
	public int amount;
}
