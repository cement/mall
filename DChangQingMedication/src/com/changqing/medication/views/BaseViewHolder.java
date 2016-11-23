package com.changqing.medication.views;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewHolder extends ViewHolder implements BaseHolder {
	
	public static View createView(ViewGroup parent, int layoutId,int viewType){
		return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent,false);
	}

	public BaseViewHolder(View itemView) {
		super(itemView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bind(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assoc(View view) {
		// TODO Auto-generated method stub
		
	}
	

}
