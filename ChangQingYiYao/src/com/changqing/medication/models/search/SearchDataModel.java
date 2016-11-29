package com.changqing.medication.models.search;

import android.graphics.drawable.Drawable;

public class SearchDataModel {

	private String name;
	private String price;
	private Drawable drawable;
	public String getName() {
		return name;
	}
	public SearchDataModel setName(String name) {
		this.name = name;
		return this;
	}
	public String getPrice() {
		return price;
	}
	public SearchDataModel setPrice(String price) {
		this.price = price;
		return this;
	}
	public Drawable getDrawable() {
		return drawable;
	}
	public SearchDataModel setDrawable(Drawable drawable) {
		this.drawable = drawable;
		return this;
	}
	
}
