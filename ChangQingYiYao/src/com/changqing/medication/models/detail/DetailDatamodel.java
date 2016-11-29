package com.changqing.medication.models.detail;

import android.graphics.drawable.Drawable;

public class DetailDatamodel {
   private String name;
   public String getName() {
	return name;
}
public DetailDatamodel setName(String name) {
	this.name = name;
	return this;
}
public Drawable getDrawable() {
	return drawable;
}
public DetailDatamodel setDrawable(Drawable drawable) {
	this.drawable = drawable;
	return this;
}
public int getPrice() {
	return price;
}
public DetailDatamodel setPrice(int price) {
	this.price = price;
	return this;
}
private Drawable drawable;
   private int price;
}
