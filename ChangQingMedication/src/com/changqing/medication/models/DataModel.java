package com.changqing.medication.models;

import android.graphics.Bitmap;

public class DataModel {

	
	public int layoutid;
	
	public String name;
	
	public String desc;
	 
	//public Bitmap bitmap;

	public int getLayoutid() {
		return layoutid;
	}

	public DataModel setLayoutid(int layoutid) {
		this.layoutid = layoutid;
		return this;
	}

	public String getName() {
		return name;
	}

	public DataModel setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public DataModel setDesc(String desc) {
		this.desc = desc;
		return this;
		
	}

	
//	public Bitmap getBitmap() {
//		return bitmap;
//	}
//
//	public void setBitmap(Bitmap bitmap) {
//		this.bitmap = bitmap;
//	}
	
	
	
}
