package com.changqing.medication.controls.home;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.changqing.medication.app.App;
import com.changqing.medication.controls.base.BaseViewHolder;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.home.SubItemDate;
import com.changqing.medication.volley.MemoryCache;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SubItemViewAdapter extends Adapter<BaseViewHolder> {

	private List<SubItemDate> mSubItemDates;
	private BaseViewHolder mSubItemHolder;
	
	
	public SubItemViewAdapter(List<SubItemDate> mSubItems) {
		// TODO Auto-generated constructor stub
		this.mSubItemDates = mSubItems;
	}
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		//Log.e(getClass().getSimpleName(),"........."+mSubItemDates.size()+".............");
		return mSubItemDates.size() ;
	}
	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_subitem_layout, parent,false);
		mSubItemHolder = new SubItemViewHolder(view,mSubItemDates);
		return mSubItemHolder;
	}
	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		// TODO Auto-generated method stub
		mSubItemHolder.bind(position);
	}

	class SubItemViewHolder extends BaseViewHolder {
		
		private List<SubItemDate> mSubItemDates;
		private TextView nameText;
		private ImageView imageview;
		private TextView descText;
		private ImageLoader mImageLoader;
		public SubItemViewHolder(View view, List<SubItemDate> subItemDates) {
			super(view);
			this.mSubItemDates = subItemDates;
			nameText = (TextView) view.findViewById(R.id.sub_item_name);
			descText = (TextView) view.findViewById(R.id.sub_item_desc);
			imageview = (ImageView) view.findViewById(R.id.sub_item_image);
			
			mImageLoader = new ImageLoader(App.sQueue,new MemoryCache());
		}
	    
		public void bind(int position) {
			SubItemDate ItemData =mSubItemDates.get(position);
			nameText.setText(ItemData.getName());
//			ImageListener listener = ImageLoader.getImageListener(imageview,R.drawable.ic_launcher, R.drawable.test_drug_yaoping);
//			mImageLoader.get("https://www.baidu.com/img/bd_logo1.png",listener, 200, 200);  
			imageview.setImageDrawable(ItemData.getDrawable());
			descText.setText(ItemData.getDesc());
		}
	}

}
