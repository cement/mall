package com.changqing.medication.controls.base;

import java.util.List;

import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class BaseAdapter<T> extends Adapter<BaseViewHolder>{
	
	private SparseArray<Integer> map;

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		return BaseViewHolder.createViewHolder(parent, BaseViewHolder.getViewIdByViewType(viewType));
	}

	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
