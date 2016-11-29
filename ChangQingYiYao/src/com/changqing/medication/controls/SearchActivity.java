package com.changqing.medication.controls;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.search.SearchResultAdapter;
import com.changqing.medication.mobile.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity{
	private RecyclerView mSearchResultPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		
		mSearchResultPage = (RecyclerView) findViewById(R.id.search_resault);
		mSearchResultPage.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
		
		
		mSearchResultPage.setAdapter(new SearchResultAdapter(R.layout.search_result,Constant.getTestSearchData()));
		getSupportActionBar().hide();
	}

}
