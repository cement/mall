package com.changqing.medication.controls.home;

import java.util.List;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.base.BaseViewHolder;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.home.MainItemData;
import com.changqing.medication.models.home.SubItemDate;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class ContentViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{

	public MainItemData mItemData;
	public List<SubItemDate> mSubItemDatas;
	public List<MainItemData> mItems;
	public ContentViewAdapter(MainItemData itemData,List<SubItemDate> subitems) {
		// TODO Auto-generated constructor stub
		super();
		this.mItemData = itemData;
		this.mSubItemDatas = subitems;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mItemData.getCount();
	}

	@Override
	public void onBindViewHolder(BaseViewHolder holder, int position) {
		holder.bind(position);
	}

	@Override
	public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		BaseViewHolder itemholder;
		if(viewType == 10000){
			//View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_position0_image, parent,false);
			ViewPager carousel = new ViewPager(parent.getContext());
			carousel.setAdapter(new CarouselPagerAdapter());
			carousel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,220));
			itemholder = new Position0ViewHolder(carousel);
		}else if(viewType == 10001){
			View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_position1_image, parent,false);
			itemholder = new Position1ViewHolder(itemView);
		}else{
			//TODO Auto-generated method stub
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_layout, parent,false);
			itemholder = new MainItemViewHolder(view,mSubItemDatas);
		}
		return itemholder;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if(0==position){
			return 10000;
		}
		if(1==position){
			return 10001;
		}
		return super.getItemViewType(position);
	}

	class Position0ViewHolder extends BaseViewHolder {

		private ViewPager carousel;
		
		public Position0ViewHolder(View itemView) {
			super(itemView);
			assoc(itemView);
		}

		@Override
		public void bind(int position) {
			// TODO Auto-generated method stub
			super.bind(position);
		}

		@Override
		public void assoc(View view) {
			// TODO Auto-generated method stub
			carousel = (ViewPager) itemView;
		}
		
		
	}
	class Position1ViewHolder extends BaseViewHolder {

		public Position1ViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void bind(int position) {
			// TODO Auto-generated method stub
			super.bind(position);
		}

		@Override
		public void assoc(View view) {
			// TODO Auto-generated method stub
			super.assoc(view);
		}
		
	}
	class MainItemViewHolder extends BaseViewHolder {

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
			//mRecyclerView.addItemDecoration(new ItemDivider(view.getContext(),ItemDivider.HORIZONTAL_LIST));
			mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  
			mRecyclerView.setLayoutManager(mLinearLayoutManager);
			mRecyclerView.setAdapter(new SubItemViewAdapter(mSubItemDatas));
		}
	}

	class CarouselPagerAdapter extends PagerAdapter{

		List<View> views = Constant.getCarouselImage();
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return views.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(views.get(position));
			return views.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(views.get(position));  
		}
	}

}
