package com.changqing.medication.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.changqing.medication.app.App;
import com.changqing.medication.mobile.R;
import com.changqing.medication.models.DataModel;
import com.changqing.medication.models.cart.CartDatamodel;
import com.changqing.medication.models.cart.CartFavorDatamodel;
import com.changqing.medication.models.detail.DetailDatamodel;
import com.changqing.medication.models.search.SearchDataModel;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;

public class Constant {
	public static ArrayList<String> getTestData() {
		ArrayList<String> mDatas = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++) {
			mDatas.add("药品名称： " + (char) i+i);
		}
		return mDatas;
	}

	public static ArrayList<Drawable> getTestDrawable() {
		ArrayList<Drawable> mDatas = new ArrayList<Drawable>();
		for (int i = 'A'; i < 'z'; i++) {
			Drawable drawable = ContextCompat.getDrawable(App.sContext, R.drawable.test_drug_yaoping);
			mDatas.add(drawable);
		}
		return mDatas;
	}

	public  static List<String> getTestDesc() {
		ArrayList<String> descs = new ArrayList<String>();
		for (int i = 'A'; i < 'z'; i++) {
			descs.add("药品描述： " + (char) i+(char)new Random().nextInt(255));
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
	//���Ե�������
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
		genre.add("母婴家庭");
		return genre;
	}
	//分类测试数据
	public static List<List<DataModel>> getGenreData(){
		List<List<DataModel>> wholeData = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			List<DataModel> datamodels = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
				DataModel model = new DataModel().setName("名称: "+"第"+i+"ҳ"+"第"+j+"项").setDesc("这是"+"第"+i+"ҳ"+"描述"+j+"信息");
				datamodels.add(model);
			}
			wholeData.add(datamodels);
		}
		return wholeData;
	}
	
	//���Թ��ﳵ����
	
	
	public static List<CartDatamodel> getTestCartData(){
		
		List<CartDatamodel> cartData = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			CartDatamodel model = new CartDatamodel();
			model.setName("药品名称: "+i).setDesc("药品描述：  "+i).setPrice(i*8).setAmount(i).setDrawable(ContextCompat.getDrawable(App.sContext, R.mipmap.test_drug_02));
			cartData.add(model);
		}
		return cartData;
	}

	
	public static List<CartFavorDatamodel> getTestFavorData(){
		List<CartFavorDatamodel> cartData = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CartFavorDatamodel model = new CartFavorDatamodel();
			model.setName("收藏: "+i).setDrawable(ContextCompat.getDrawable(App.sContext, R.mipmap.test_drug_03));
			cartData.add(model);
		}
		
		return cartData;
		
	}
	
	public static List<List<DetailDatamodel>> getTestDetailData(){
		List<List<DetailDatamodel>> wholeData = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			List<DetailDatamodel> deatailModel = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
				DetailDatamodel model = new DetailDatamodel().setName("详情一: "+i+"ҳ"+"详情二： "+j+"等等").setPrice(i*j);
				deatailModel.add(model);
			}
			wholeData.add(deatailModel);
		}
		return wholeData;
		
	}
	
	public static List<SearchDataModel> getTestSearchData(){
		
		List<SearchDataModel> searchModel = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			searchModel.add(new SearchDataModel().setPrice(String.valueOf(i*i)).setDrawable(ContextCompat.getDrawable(App.sContext, R.mipmap.test_drug_04)));
		}
		return searchModel;
		
	}

	public static List<View> getCarouselImage() {
		// TODO Auto-generated method stub
		
		List<View> views = new ArrayList<>();
		View view1 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_a, null);
		views.add(view1);
		View view2 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_b, null);
		views.add(view2);
		View view3 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_c, null);
		views.add(view3);
		View view4 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_a, null);
		views.add(view4);
		View view5 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_b, null);
		views.add(view5);
		View view6 = LayoutInflater.from(App.sContext).inflate(R.layout.main_position0_image_c, null);
		views.add(view6);
		
		return views;
	}
}
