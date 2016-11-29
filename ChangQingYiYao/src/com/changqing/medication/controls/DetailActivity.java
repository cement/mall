package com.changqing.medication.controls;

import java.util.ArrayList;
import java.util.List;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.detail.DetailFragmentAdapter;
import com.changqing.medication.mobile.R;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class DetailActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.detail_layout);
		
		
		ViewPager mDetailPage = (ViewPager)findViewById(R.id.details_page);
		
		List<Integer> layoutids = new ArrayList<>();
		layoutids.add(R.layout.detail_content_wares);
		layoutids.add(R.layout.detail_content_desc);
		layoutids.add(R.layout.detail_content_evaluate);
		mDetailPage.setAdapter(new DetailFragmentAdapter(getSupportFragmentManager(),layoutids,Constant.getTestDetailData()));
		mDetailPage.setCurrentItem(1);
		
		getSupportActionBar().hide();
	}

}
