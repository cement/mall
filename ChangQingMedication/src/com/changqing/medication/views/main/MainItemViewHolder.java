package com.changqing.medication.views.main;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.main.SubItemDate;
import com.changqing.medication.views.ItemDivider;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

public class MainItemViewHolder extends ViewHolder {

	public TextView genretTextView;
	public RecyclerView mRecyclerView;
	public LinearLayoutManager mLinearLayoutManager;
	public List<SubItemDate> mSubItemDatas;
	public MainItemViewHolder(View view,List<SubItemDate> subItemDatas) {
		super(view);
		// TODO Auto-generated constructor stub
		mSubItemDatas = subItemDatas;
		genretTextView = (TextView) view.findViewById(R.id.item_genre);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.item_content);
		mLinearLayoutManager = new LinearLayoutManager(view.getContext());  
		mRecyclerView.addItemDecoration(new ItemDivider(view.getContext(),ItemDivider.HORIZONTAL_LIST));
	}
	public void bind(int position) {
		//genretTextView.setText(text);
		mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  
		mRecyclerView.setLayoutManager(mLinearLayoutManager);
		mRecyclerView.setAdapter(new SubItemViewAdapter(mSubItemDatas));
	}
}
