package com.changqing.medication.controls;

import java.util.List;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.base.BaseViewHolder;
import com.changqing.medication.controls.cart.CartAddedAdapter;
import com.changqing.medication.controls.cart.CartFavorAdapter;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.cart.CartDatamodel;
import com.changqing.medication.models.cart.CartFavorDatamodel;
import com.changqing.medication.views.ItemDivider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

public class CartActivity extends AppCompatActivity{

	private RecyclerView mCartViewedView;
	private RecyclerView mCartAddedView;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart_main_layout);
		
		
		mCartAddedView = (RecyclerView) findViewById(R.id.cart_added);
		mCartAddedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		List<CartDatamodel> cartAddedDatas = Constant.getTestCartData();
		mCartAddedView.addItemDecoration(new ItemDivider(this, ItemDivider.VERTICAL_LIST));
		
		Adapter<BaseViewHolder> addedAdapter = new CartAddedAdapter(R.layout.cart_item_layout, cartAddedDatas);
		mCartAddedView.setAdapter(addedAdapter);
		
		
		
		mCartViewedView = (RecyclerView) findViewById(R.id.cart_viewed);
		mCartViewedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		List<CartFavorDatamodel> cartFavorDatas = Constant.getTestFavorData();
		
		Adapter<BaseViewHolder> favoredAdapter = new CartFavorAdapter(R.layout.cart_favorites_layout, cartFavorDatas);
		mCartViewedView.setAdapter(favoredAdapter);
		getSupportActionBar().hide();
		
	}

}
