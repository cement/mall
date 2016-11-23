package com.changqing.medication.views.main;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.main.MainItemData;
import com.changqing.medication.models.main.SubItemDate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentViewAdapter extends RecyclerView.Adapter<MainItemViewHolder>{

//	private List<RecyclerView> mRecycles;
	public MainItemData mItemData;
	public List<SubItemDate> mSubItemDatas;
	public List<MainItemData> mItems;
	public ContentViewAdapter(MainItemData itemData,List<SubItemDate> subitems) {
		// TODO Auto-generated constructor stub
		super();
		//this.mItems = items;
		this.mItemData = itemData;
		this.mSubItemDatas = subitems;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mItemData.getCount();
	}

	@Override
	public void onBindViewHolder(MainItemViewHolder itemviewholder, int position) {
		// TODO Auto-generated method stub
		//viewholder.mRecyclerView = mRecycles.get(position);
//		viewholder.itemImageView.setImageResource(mImages.get(position));
		//viewholder.dcq(position);
		itemviewholder.bind(position);
	}

	@Override
	public MainItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		 //TODO Auto-generated method stub
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_layout, parent,false);
		MainItemViewHolder itemholder = new MainItemViewHolder(view,mSubItemDatas);
		return itemholder;
	}

//	@Override
//	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
//		// TODO Auto-generated method stub
//		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
//		ItemViewHolder itemholder = new ItemViewHolder(view);
//		return itemholder;
//	}


}
