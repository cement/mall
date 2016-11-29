package com.changqing.medication.controls;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.changqing.medication.app.App;
import com.changqing.medication.mobile.R;
import com.changqing.medication.volley.MemoryCache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class VolleyTest extends AppCompatActivity{

	private ImageView mImageView;
	private ImageLoader mImageLoader;
	private long start;
	private long end;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volley_test);
		mImageView = (ImageView)findViewById(R.id.volley_test);
		start = System.currentTimeMillis();
		inintImageLoader();
	}
	
	private void inintImageLoader() {
		mImageLoader = new ImageLoader(App.sQueue,new MemoryCache());
		ImageListener listener = ImageLoader.getImageListener(mImageView,R.drawable.ic_launcher, R.drawable.test_drug_yaoping);
		mImageLoader.get("https://www.baidu.com/img/bd_logo1.png",listener, 0, 0);  
	
	    end = System.currentTimeMillis();
	    
	    System.out.println("测试网络加载时间"+(start-end));
	    Toast.makeText(this, "测试网络加载时间", Toast.LENGTH_SHORT).show();
	}
}
