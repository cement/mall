package com.changqing.medication.controls;

import com.changqing.medication.constant.Constant;
import com.changqing.medication.controls.genre.GenreNaviListAdapter;
import com.changqing.medication.controls.genre.GenreViewPagerAdapter;
import com.changqing.medication.mobile.R;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class GenreActivity extends AppCompatActivity{

	private ViewPager mGenreContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.genre_layout);
		
		ListView drawerList = (ListView) findViewById(R.id.genre_navigation);
		drawerList.setAdapter(new GenreNaviListAdapter(Constant.getNaviList()));
		drawerList.setOnItemClickListener(new DrawerListItemClickListener());
		
		mGenreContent = (ViewPager) findViewById(R.id.genre_container);
		mGenreContent.setAdapter(new GenreViewPagerAdapter(getSupportFragmentManager(),R.layout.genre_item_layout,Constant.getGenreData()));
	    //隐藏actionbar
		getSupportActionBar().hide();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_genre) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class DrawerListItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			System.out.println("........................:   "+position+":"+id);
		}
		
	}


}
