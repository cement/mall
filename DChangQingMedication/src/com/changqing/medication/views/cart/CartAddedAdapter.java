package com.changqing.medication.views.cart;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.cart.CartDatamodel;
import com.changqing.medication.views.BaseViewHolder;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CartAddedAdapter extends Adapter<BaseViewHolder> {

	private List<CartDatamodel> mDatas;
	private int mItemLayoutId;
	
	public CartAddedAdapter(int itemLayoutId,List<CartDatamodel> datas) {
		super();
		this.mDatas = datas;
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View itemView = BaseViewHolder.createView(parent, mItemLayoutId, viewType);
		return new CartAddedViewHolder(itemView);
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
	
	class CartAddedViewHolder extends BaseViewHolder{
		
		ImageView imageView;
		TextView nameView;
		TextView descView;
		TextView priceView;
		TextView amountView;

		public CartAddedViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
			assoc(itemView);
		}

		@Override
		public void assoc(View view) {
			imageView = (ImageView) view.findViewById(R.id.cart_added_wares_image);
			nameView = (TextView) view.findViewById(R.id.cart_added_wares_name);
			descView = (TextView) view.findViewById(R.id.cart_added_wares_desc);
			priceView = (TextView) view.findViewById(R.id.cart_added_wares_price);
			amountView = (TextView) view.findViewById(R.id.cart_added_wares_amount);
		}
		
		@Override
		public void bind(int position) {
			imageView.setImageDrawable(mDatas.get(position).getDrawable());
			nameView.setText(mDatas.get(position).getName());
			descView.setText(mDatas.get(position).getDesc());
			priceView.setText(String.valueOf(mDatas.get(position).getPrice()));
			amountView.setText(String.valueOf(mDatas.get(position).getAmount()));
		}


	}

}
