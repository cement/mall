package com.changqing.medication.views.genre;

import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;

import com.changqing.medication.models.main.MainItemData;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GenreContentAdapter extends Adapter<GenreItemViewHolder> {

	private int viewId;
	
	//Map<Integer,Integer> modleandview = Canstanct.
	@Override
	public GenreItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
		GenreItemViewHolder holder = new GenreItemViewHolder(itemView);
		return holder;
	}

	@Override
	public void onBindViewHolder(GenreItemViewHolder holder, int position) {
		// TODO Auto-generated method stub
		holder.bind(position);
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}


}
