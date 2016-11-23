package com.changqing.medication.views.cart;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.cart.CartFavorDatamodel;
import com.changqing.medication.views.BaseViewHolder;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CartFavorAdapter extends Adapter<BaseViewHolder> {


	private int mItemLayoutId;
	private List<CartFavorDatamodel> mDatas;
	
	public CartFavorAdapter(int itemLayoutId,List<CartFavorDatamodel> datas) {
		super();
		this.mDatas = datas;
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId, parent,false);
		return new CartViewedViewHolder(itemView);
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


	class CartViewedViewHolder extends BaseViewHolder{
		
		private ImageButton imageView;
		private TextView  name;

		public CartViewedViewHolder(View itemView) {
			super(itemView);
			assoc(itemView);
		}


		@Override
		public void assoc(View view) {
			imageView = (ImageButton) view.findViewById(R.id.cart_favor_image);
			name = (TextView) view.findViewById(R.id.cart_favor_name);
			
		}
		@Override
		public void bind(int position) {
			imageView.setImageDrawable(mDatas.get(position).getDrawable());
			name.setText(mDatas.get(position).getName());
//			imageView.setImageDrawable(mDatas.get(position).getDrawable());
//			name.setText(mDatas.get(position).getName());
			
		}
		
	}



}
