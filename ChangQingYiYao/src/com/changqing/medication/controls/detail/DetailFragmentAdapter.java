package com.changqing.medication.controls.detail;

import java.util.List;

import com.changqing.medication.models.detail.DetailDatamodel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DetailFragmentAdapter extends FragmentPagerAdapter {
	
	private List<List<DetailDatamodel>> mDatas;
	private List<Integer> mItemLayoutIds;

	public DetailFragmentAdapter(FragmentManager fm,List<Integer> itemLayoutIds,List<List<DetailDatamodel>> datas) {
		super(fm);
		this.mDatas = datas;
		this.mItemLayoutIds = itemLayoutIds;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mItemLayoutIds.size();
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return DetailContentFragment.newInstance(mItemLayoutIds.get(position), mDatas.get(position));
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

}
