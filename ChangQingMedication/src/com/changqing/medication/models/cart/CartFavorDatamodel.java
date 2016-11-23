package com.changqing.medication.models.cart;

import android.graphics.drawable.Drawable;

public class CartFavorDatamodel {
	Drawable drawable;
	String name;
	public Drawable getDrawable() {
		return drawable;
	}
	public CartFavorDatamodel setDrawable(Drawable drawable) {
		this.drawable = drawable;
		return this;
	}
	public String getName() {
		return name;
	}
	public CartFavorDatamodel setName(String name) {
		this.name = name;
		return this;
		
	}
}
