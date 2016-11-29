package com.changqing.medication.services;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

public class NetworkService extends Service {

	
	private RequestQueue mRequestQueue;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		mRequestQueue = Volley.newRequestQueue(getApplicationContext());  
		super.onCreate();
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		// TODO Auto-generated method stub
		System.out.println(intent.getStringExtra("url"));
		StringRequest stringRequest = new StringRequest(intent.getStringExtra("url"),
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Log.i("TAG", response);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.i("TAG", error.getMessage(), error);
					}
				});
		
		mRequestQueue.add(stringRequest);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
}
