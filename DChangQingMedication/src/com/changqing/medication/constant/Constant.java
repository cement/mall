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
	//���Ե�������
	public static  List<String> getNaviList(){
		ArrayList<String> genre = new ArrayList<String>();
		genre.add("��ͥ����");
		genre.add("ר����ҩ");
		genre.add("������ҩ");
		genre.add("��֢��ҩ");
		genre.add("ά���ظ�");
		genre.add("�����۾�");
		genre.add("�̲�����");
		genre.add("��е����");
		genre.add("ҩױ����");
		genre.add("��ͥ����");
		genre.add("ĸӤ��ͥ");
		return genre;
	}
	//���Զ���������
	public static List<List<DataModel>> getGenreData(){
		List<List<DataModel>> wholeData = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			List<DataModel> datamodels = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
				DataModel model = new DataModel().setName("�й�: "+"��"+i+"ҳ"+"����"+j+"��").setDesc("������"+"��"+i+"ҳ"+"����"+j+"��");
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
			model.setName("����: "+i).setDesc("������ "+i).setPrice(i*8).setAmount(i).setDrawable(ContextCompat.getDrawable(App.sContext, R.drawable.ic_launcher));
			cartData.add(model);
		}
		return cartData;
	}

	
	public static List<CartFavorDatamodel> getTestFavorData(){
		List<CartFavorDatamodel> cartData = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CartFavorDatamodel model = new CartFavorDatamodel();
			model.setName("����: "+i).setDrawable(ContextCompat.getDrawable(App.sContext, R.drawable.ic_launcher));
			cartData.add(model);
		}
		
		return cartData;
		
	}
}
