package com.changqing.medication.cotroller;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.main.R;
import com.changqing.medication.models.main.MainItemData;
import com.changqing.medication.models.main.SubItemDate;
import com.changqing.medication.views.ItemDivider;
import com.changqing.medication.views.main.ContentViewAdapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import test.TestActivity;

public class MainActivity extends AppCompatActivity {

	private InputMethodManager mInputManager;
	private ImageButton mSearchButton;
	private SingleClickListener mClickListener;
	private RecyclerView mContent;
	private ContentViewAdapter mContentViewAdapter;
	private LinearLayout mFooter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);

		mSearchButton = (ImageButton) findViewById(R.id.header_search);
		mClickListener = new SingleClickListener();
		mSearchButton.setOnClickListener(mClickListener);

		mContent = (RecyclerView) findViewById(R.id.main_content);
		mContent.setLayoutManager(new LinearLayoutManager(this));
		
		List<SubItemDate> subDatas = new ArrayList<SubItemDate>();
		List<String> name = Constant.getTestData();
		List<Drawable> images = Constant.getTestDrawable();
		List<String> descs = Constant.getTestDesc();
		
		
		MainItemData itemData = new MainItemData(10,Constant.getTestGenre());
		
		
		for (int i = 0; i < name.size(); i++) {
			SubItemDate ItemData = new SubItemDate();
			subDatas.add(ItemData.setName(name.get(i)).setDrawable(images.get(i)).setDesc(descs.get(i)));

		}
		// subDatas.add(new SubItemDate().setName("jack"));
		// subDatas.add(new SubItemDate().setName("rose"));
		// subDatas.add(new SubItemDate().setName("blan"));
		mContentViewAdapter = new ContentViewAdapter(itemData, subDatas);
		mContent.setAdapter(mContentViewAdapter);

		mContent.addItemDecoration(new ItemDivider(this, ItemDivider.VERTICAL_LIST));

		getSupportActionBar().hide();
		// mInputManager = (InputMethodManager)
		// getSystemService(Context.INPUT_METHOD_SERVICE);
		
		
		mFooter = (LinearLayout)findViewById(R.id.footer);
		
		
		
	}


	private class SingleClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			Log.e(getClass().getSimpleName(), "1.............mSearchButton onClick...........");
			// mInputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
			// //Ç¿ÖÆÒþ²Ø¼üÅÌ
			// mInputManager.toggleSoftInput(0,
			// InputMethodManager.HIDE_NOT_ALWAYS);
			// }
		}
	}

	
}
