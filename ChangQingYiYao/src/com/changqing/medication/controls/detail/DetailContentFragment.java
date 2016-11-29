package com.changqing.medication.controls.detail;

import java.util.List;

import com.changqing.medication.models.detail.DetailDatamodel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailContentFragment extends Fragment{
	
	private static String LAYOUTID = "layoutId";
	private List<DetailDatamodel> mDatas;
	

	private DetailContentFragment(List<DetailDatamodel> mDatas) {
		super();
		this.mDatas = mDatas;
	}

	public static DetailContentFragment newInstance(int itemLayoutId,List<DetailDatamodel> datas) {
		DetailContentFragment fragment = new DetailContentFragment(datas);
		Bundle args = new Bundle();
		args.putInt(LAYOUTID , itemLayoutId);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(getArguments().getInt(LAYOUTID), container, false);
		//rootView.findViewById(R.id.)
		return rootView;
	}

}
