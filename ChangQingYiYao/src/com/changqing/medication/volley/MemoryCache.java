package com.changqing.medication.volley;

import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.changqing.medication.app.App;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class MemoryCache implements ImageCache {  
  
    private LruCache<String, Bitmap> mCache;  
  
    
    public MemoryCache() {
		super();
		  int cacheSize = 10*1024*1024;  
		 //int cacheSize = (int) (Runtime.getRuntime().totalMemory()*2/3);  
	        mCache = new LruCache<String, Bitmap>(cacheSize) {  
	            @Override  
	            protected int sizeOf(String key, Bitmap bitmap) {  
	                return bitmap.getByteCount();  
	            }  
	        };  
	}
  
    @Override  
    public Bitmap getBitmap(String url) { 
    	System.out.println("......getBitmap............");
    	dcq();
        return mCache.get(url);  
    }  
  
    @Override  
    public void putBitmap(String url, Bitmap bitmap) {  
    	 System.out.println("......putBitmap............");
    	 dcq();
        mCache.put(url, bitmap);  
    }  
  
    
    public static void dcq(){
    	//应用程序最大可用内存  
        int maxMemory = ((int) Runtime.getRuntime().maxMemory())/1024/1024;  
        //应用程序已获得内存  
        long totalMemory = (Runtime.getRuntime().totalMemory())/1024/1024;  
        //应用程序已获得内存中未使用内存  
        long freeMemory = ((int) Runtime.getRuntime().freeMemory())/1024/1024;  
      
        ActivityManager manager = (ActivityManager)App.sContext.getSystemService(Context.ACTIVITY_SERVICE);  
        int heapSize = manager.getMemoryClass();  
       
        System.out.println("---> maxMemory="+maxMemory+"M,totalMemory="+totalMemory+"M,freeMemory="+freeMemory+"M"); 
        System.out.println("heapSize: "+heapSize +"MB"); 
    }
}  