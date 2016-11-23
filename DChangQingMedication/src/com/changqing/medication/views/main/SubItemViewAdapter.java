package com.changqing.medication.views.main;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.main.SubItemDate;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubItemViewAdapter extends Adapter<SubItemViewHolder> {

	private List<SubItemDate> mSubItemDates;
	private SubItemViewHolder mSubItemHolder;
	public SubItemViewAdapter(List<SubItemDate> mSubItems) {
		// TODO Auto-generated constructor stub
		this.mSubItemDates = mSubItems;
	}
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		Log.e(getClass().getSimpleName(),"........."+mSubItemDates.size()+".............");
		return mSubItemDates.size() ;
	}
	@Override
	public SubItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.min_sub_item_layout, parent,false);
		mSubItemHolder = new SubItemViewHolder(view,mSubItemDates);
		return mSubItemHolder;
	}
	@Override
	public void onBindViewHolder(SubItemViewHolder holder, int position) {
		// TODO Auto-generated method stub
		mSubItemHolder.bind(position);
	}


}
