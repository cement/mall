package com.changqing.medication.controls.genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.changqing.medication.models.DataModel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GenreViewPagerAdapter extends FragmentPagerAdapter {

	private List<List<DataModel>> mWholeDatas;
	private List<DataModel> mPageDatas = new ArrayList<>();
	private int mFragmentLayoutId;
	
    public GenreViewPagerAdapter(FragmentManager fm,int fragmentLayoutId,List<List<DataModel>> datas) {
		super(fm);
		this.mWholeDatas = datas;
		this.mFragmentLayoutId = fragmentLayoutId;
	}

	@Override
	public Fragment getItem(int position) {
		mPageDatas.addAll(mWholeDatas.get(position));
		return GenreContentFragment.newInstance(mFragmentLayoutId,mPageDatas);
	}

	@Override
	public int getCount() {
		return mWholeDatas.size();
	}
}
