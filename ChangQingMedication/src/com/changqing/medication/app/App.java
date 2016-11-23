package com.changqing.medication.app;

import android.app.Application;
import android.content.Context;

public class App extends Application{

	public static Context sContext;
	public static Application sApp;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sContext = getApplicationContext();
		sApp = this;
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerActivityLifecycleCallbacks(callback);
	}

	@Override
	public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterActivityLifecycleCallbacks(callback);
	}

	@Override
	public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.registerOnProvideAssistDataListener(callback);
	}

	@Override
	public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.unregisterOnProvideAssistDataListener(callback);
	}

	
}
