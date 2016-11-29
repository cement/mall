package com.changqing.medication.controls.search;

import java.util.List;

import com.changqing.medication.controls.base.BaseViewHolder;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.search.SearchDataModel;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchResultAdapter extends Adapter<BaseViewHolder> {
    
	
	private int itemLayoutId;
	private List<SearchDataModel> mDatas;
	
	public SearchResultAdapter(int itemLayoutId, List<SearchDataModel> mDatas) {
		super();
		this.itemLayoutId = itemLayoutId;
		this.mDatas = mDatas;
	}

	@Override
	public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, parent,false);
		return new SearchResultViewHolder(itemView);
	}



	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		// TODO Auto-generated method stub
		holder.bind(position);
	}
	

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	class SearchResultViewHolder extends BaseViewHolder {
		
		private ImageView image;
		private TextView price;

		public SearchResultViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
			assoc(itemView);
		}

		@Override
		public void bind(int position) {
			image.setImageDrawable(mDatas.get(position).getDrawable());
			price.setText(mDatas.get(position).getPrice());
		}

		@Override
		public void assoc(View view) {
			image = (ImageView) view.findViewById(R.id.search_result_image);
			price = (TextView) view.findViewById(R.id.search_result_price);
		}

	}


	
}
