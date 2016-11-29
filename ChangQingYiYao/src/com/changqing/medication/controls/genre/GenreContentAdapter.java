package com.changqing.medication.controls.genre;

import com.changqing.medication.controls.base.BaseViewHolder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GenreContentAdapter extends Adapter<BaseViewHolder> {

	
	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
		BaseViewHolder holder = new GenreItemViewHolder(itemView);
		return holder;
	}

	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		// TODO Auto-generated method stub
		holder.bind(position);
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}


}
