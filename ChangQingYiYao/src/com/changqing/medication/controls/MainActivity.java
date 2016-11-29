package com.changqing.medication.controls;

import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.home.ContentViewAdapter;
import com.changqing.medication.db.sqlserver.ResultSetLoader;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.home.MainItemData;
import com.changqing.medication.models.home.SubItemDate;
import com.changqing.medication.views.BaseItemView;
import com.changqing.medication.views.ItemDivider;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

	private InputMethodManager mInputManager;
	private ImageButton mSearchButton;
	// private SingleClickListener mClickListener;
	private RecyclerView mMainContent;
	private ContentViewAdapter mContentViewAdapter;
	private LinearLayout mFooter;
	private ImageButton mHeaderHome;
	private List<BaseItemView> mFooters = new ArrayList<BaseItemView>();
	private SwipeRefreshLayout mSwipeLayout;
	private LinearLayoutManager mContentlayoutManager;
	
	private ImageLoader mImageLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_layout);

		//mSearchButton = (ImageButton) findViewById(R.id.header_home);
		// mClickListener = new SingleClickListener();
		// mSearchButton.setOnClickListener(mClickListener);

		mMainContent = (RecyclerView) findViewById(R.id.main_content);
		mContentlayoutManager = new LinearLayoutManager(this);
		mMainContent.setLayoutManager(mContentlayoutManager);

		//mMainContent.addOnItemTouchListener(new ItemOnclickListener());
	


		List<SubItemDate> subDatas = new ArrayList<SubItemDate>();
		List<String> name = Constant.getTestData();
		List<Drawable> images = Constant.getTestDrawable();
		List<String> descs = Constant.getTestDesc();

		MainItemData itemData = new MainItemData(10, Constant.getTestGenre());

		for (int i = 0; i < name.size(); i++) {
			SubItemDate ItemData = new SubItemDate();
			subDatas.add(ItemData.setName(name.get(i)).setDrawable(images.get(i)).setDesc(descs.get(i)));

		}
		mContentViewAdapter = new ContentViewAdapter(itemData, subDatas);
		mMainContent.setAdapter(mContentViewAdapter);

		mMainContent.addItemDecoration(new ItemDivider(this, ItemDivider.VERTICAL_LIST));

		getSupportActionBar().hide();

		initFooterTabIndicator();
		
		//initLoader();
		
		initSwipLayout();
		

	}

	

	private void initSwipLayout() {
		mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_layout);

		mSwipeLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				System.out.println(".........Refreshing...........");
				mSwipeLayout.setRefreshing(false);
			}
		});
		mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
				android.R.color.holo_orange_light, android.R.color.holo_red_light);
		mSwipeLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_blue_dark);
		
		mMainContent.addOnScrollListener(new RecyclerView.OnScrollListener() {

			   private int lastVisibleItem;

			@Override
			   public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			    super.onScrollStateChanged(recyclerView, newState);
//			   
			    if (newState == RecyclerView.SCROLL_STATE_IDLE
			    		&& mContentlayoutManager.findLastVisibleItemPosition()+1 == mContentViewAdapter.getItemCount() ) {
			    	mSwipeLayout.setRefreshing(true);
			    	
			     System.out.println("此处网络请求数据代码，sendRequest .....");
			     mSwipeLayout.setRefreshing(false);
			    // handler.sendEmptyMessageDelayed(0, 3000);
			    }
			   }

			   @Override
			   public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			    super.onScrolled(recyclerView, dx, dy);
			    //lastVisibleItem = mContentlayoutManager.findLastVisibleItemPosition();
			   }
			  });
		
	}

	private void initLoader() {
		// TODO Auto-generated method stub
		LoaderManager loadermanager = getSupportLoaderManager();
		Bundle bundle = new Bundle();
		bundle.putString("sql", "SELECT top 200 * FROM [UdoDBCQ].[dbo].[Customer]");
		LoaderCallbacks<ResultSet> loadCallback = new MainLoaderCallbacks();
		loadermanager.initLoader(1000, bundle, loadCallback);
		
	}

	private void initFooterTabIndicator() {
		
		
		BaseItemView home = (BaseItemView) findViewById(R.id.main_footer_home);
		BaseItemView genre = (BaseItemView) findViewById(R.id.main_footer_genre);
		BaseItemView cart = (BaseItemView) findViewById(R.id.main_footer_cart);
		BaseItemView mine = (BaseItemView) findViewById(R.id.main_footer_mine);

		mFooters.add(home);
		mFooters.add(genre);
		mFooters.add(cart);
		mFooters.add(mine);

		home.setBackColor(Color.parseColor("#ff00ff00"));
		genre.setBackColor(Color.parseColor("#ff00ff00"));
		cart.setBackColor(Color.parseColor("#ff00ff00"));
		mine.setBackColor(Color.parseColor("#ff00ff00"));
	
		OnClickListener listener = new SingleClickListener();
		home.setOnClickListener(listener);
		genre.setOnClickListener(listener);
		cart.setOnClickListener(listener);
		mine.setOnClickListener(listener);

		home.setIconAlpha(1.0f);
	}



	 private class SingleClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			for (int i = 0; i < mFooters.size(); i++) {
				mFooters.get(i).setIconAlpha(0);
			}

			switch (view.getId()) {
			case R.id.main_footer_home:
				mFooters.get(0).setIconAlpha(1.0f);
				Intent volleyIntent = new Intent(MainActivity.this,VolleyTest.class);
				startActivity(volleyIntent);
				break;
			case R.id.main_footer_genre:
				mFooters.get(1).setIconAlpha(1.0f);
				Intent genreIntent = new Intent(MainActivity.this,GenreActivity.class);
				startActivity(genreIntent);
				break;
			case R.id.main_footer_cart:
				mFooters.get(2).setIconAlpha(1.0f);
				Intent cartIntent = new Intent(MainActivity.this,CartActivity.class);
				startActivity(cartIntent);
				break;
			case R.id.main_footer_mine:
				mFooters.get(3).setIconAlpha(1.0f);
				Intent DetailIntent = new Intent(MainActivity.this,DetailActivity.class);
				startActivity(DetailIntent);
				break;
			}
			
		}
		 
	 }

	public class ItemOnclickListener implements OnItemTouchListener {

		@Override
		public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onTouchEvent(RecyclerView rv, MotionEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
			// TODO Auto-generated method stub

		}

	}

	public class MainLoaderCallbacks implements LoaderCallbacks<ResultSet> {

		@Override
		public Loader<ResultSet> onCreateLoader(int id, Bundle bundle) {
			ResultSetLoader loader = new ResultSetLoader(getApplicationContext(),bundle);
			return loader;
		}

		@Override
		public void onLoadFinished(Loader<ResultSet> loader, ResultSet reaultSet) {
			// TODO Auto-generated method stub
			 try {
				 if(reaultSet!=null){
					 while (reaultSet.next()) {  
						 System.out.println(".......reaultSet........: "+reaultSet);  
						 System.out.println(reaultSet.getString(4) + " " + reaultSet.getString(6));  
					 }
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}  
			//mMainContent.getAdapter().notifyDataSetChanged();
			// System.out.println("........................................: ");  

		}

		@Override
		public void onLoaderReset(Loader<ResultSet> loader) {
			// TODO Auto-generated method stub

		}

	}
	

}
