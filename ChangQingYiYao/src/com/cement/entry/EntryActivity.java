package com.cement.entry;

import com.changqing.medication.controls.CartActivity;
import com.changqing.medication.controls.DetailActivity;
import com.changqing.medication.controls.GenreActivity;
import com.changqing.medication.controls.MainActivity;
import com.changqing.medication.controls.SearchActivity;
import com.changqing.medication.mobile.R;
import com.changqing.medication.services.NetworkService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

	public class EntryActivity extends AppCompatActivity{

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.entry);
			
			CursorLoader loader;
		}
		

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.main_menu, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			int id = item.getItemId();
			if (id == R.id.action_genre) {
				Intent intent = new Intent(this,GenreActivity.class);
				startActivity(intent);
				return true;
			}
			if (id == R.id.action_cart) {
				Intent intent = new Intent(this,CartActivity.class);
				startActivity(intent);
				return true;
			}
			if (id == R.id.action_main) {
				Intent intent = new Intent(this,MainActivity.class);
				startActivity(intent);
				return true;
			}
			if (id == R.id.action_details) {
				Intent intent = new Intent(this,DetailActivity.class);
				startActivity(intent);
				return true;
			}
			if (id == R.id.action_search) {
				Intent intent = new Intent(this,SearchActivity.class);
				startActivity(intent);
				return true;
			}
			if (id == R.id.action_start_service) {
				Intent intent = new Intent(this,NetworkService.class);
				intent.putExtra("url", "http://www.baidu.com");
				startService(intent);
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
	}
