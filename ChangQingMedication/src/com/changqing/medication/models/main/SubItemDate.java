package com.changqing.medication.models.main;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class SubItemDate {
	public String name;
	public Drawable drawable;
	public String desc;

	public Drawable getDrawable() {
		return drawable;
	}

	public SubItemDate setDrawable(Drawable drawable) {
		this.drawable = drawable;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public SubItemDate setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getName() {
		return name;
	}

	public SubItemDate setName(String name) {
		this.name = name;
		return this;
	}
}
