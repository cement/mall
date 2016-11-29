package com.changqing.medication.controls.base;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseViewHolder extends ViewHolder{
	

	public BaseViewHolder(View itemView) {
		super(itemView);
		// TODO Auto-generated constructor stub
	}

	public static BaseViewHolder createViewHolder(View View) {
		BaseViewHolder holder = new BaseViewHolder(View);
		return holder;
	}

	public static BaseViewHolder createViewHolder(ViewGroup parent, int layoutId) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
		BaseViewHolder holder = new BaseViewHolder(itemView);
		return holder;
	}

	
	
	public static int getViewIdByViewType(int viewType) {
		// TODO Auto-generated method stub
		return viewType;
	}



}
