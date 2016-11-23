package com.changqing.medication.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.changqing.medication.app.App;
import com.changqing.medication.main.R;
import com.changqing.medication.models.DataModel;
import com.changqing.medication.models.cart.CartDatamodel;
import com.changqing.medication.models.cart.CartFavorDatamodel;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class Constant {
	public static ArrayList<String> getTestData() {
		ArrayList<String> mDatas = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++) {
			mDatas.add("" + (char) i);
		}
		return mDatas;
	}

	public static ArrayList<Drawable> getTestDrawable() {
		ArrayList<Drawable> mDatas = new ArrayList<Drawable>();
		for (int i = 'A'; i < 'z'; i++) {
			Drawable drawable = ContextCompat.getDrawable(App.sContext, R.drawable.aa);
			mDatas.add(drawable);
		}
		return mDatas;
	}

	public  static List<String> getTestDesc() {
		ArrayList<String> descs = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++) {
			descs.add("......." + (char) i+"............");
		}
		return descs;
	}
	public  static List<String> getTestGenre() {
		ArrayList<String> descs = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++) {
			descs.add("......." + (char) i+(char) i+"............");
		}
		return descs;
	}
	//测试导航数据
	public static  List<String> getNaviList(){
		ArrayList<String> genre = new ArrayList<String>();
		genre.add("家庭常备");
		genre.add("专科用药");
		genre.add("慢病用药");
		genre.add("对症找药");
		genre.add("维生素钙");
		genre.add("隐形眼镜");
		genre.add("滋补保健");
		genre.add("器械成人");
		genre.add("药妆个护");
		genre.add("家庭常备");
		genre.add("母婴家庭");
		return genre;
	}
	//测试多层分类数据
	public static List<List<DataModel>> getGenreData(){
		List<List<DataModel>> wholeData = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			List<DataModel> datamodels = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
				DataModel model = new DataModel().setName("中国: "+"第"+i+"页"+"，第"+j+"条").setDesc("描述："+"第"+i+"页"+"，第"+j+"条");
				datamodels.add(model);
			}
			wholeData.add(datamodels);
		}
		return wholeData;
	}
	
	//测试购物车数据
	
	
	public static List<CartDatamodel> getTestCartData(){
		
		List<CartDatamodel> cartData = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			CartDatamodel model = new CartDatamodel();
			model.setName("名字: "+i).setDesc("描述： "+i).setPrice(i*8).setAmount(i).setDrawable(ContextCompat.getDrawable(App.sContext, R.drawable.ic_launcher));
			cartData.add(model);
		}
		return cartData;
	}

	
	public static List<CartFavorDatamodel> getTestFavorData(){
		List<CartFavorDatamodel> cartData = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CartFavorDatamodel model = new CartFavorDatamodel();
			model.setName("名字: "+i).setDrawable(ContextCompat.getDrawable(App.sContext, R.drawable.ic_launcher));
			cartData.add(model);
		}
		
		return cartData;
		
	}
}
