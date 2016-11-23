package com.changqing.medication.views;

import java.util.List;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

public class BaseRecyAdapter<T> extends Adapter<BaseViewHolder>{

	
	private List<T> mDatas;
	private int mItemLayoutId;
	
	public BaseRecyAdapter(List<T> mDatas, int mItemLayoutId) {
		super();
		this.mDatas = mDatas;
		this.mItemLayoutId = mItemLayoutId;
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View view = BaseViewHolder.createView(parent, mItemLayoutId, viewType);
		return null;
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
