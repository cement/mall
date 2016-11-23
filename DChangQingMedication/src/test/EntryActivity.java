package test;

import com.changqing.medication.cotroller.CartActivity;
import com.changqing.medication.cotroller.GenreActivity;
import com.changqing.medication.cotroller.MainActivity;
import com.changqing.medication.main.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

	public class EntryActivity extends AppCompatActivity{

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.cart_item_layout);
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
			return super.onOptionsItemSelected(item);
		}
	}
