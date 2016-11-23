package com.changqing.medication.views.genre;

import java.util.ArrayList;
import java.util.List;

import com.changqing.medication.main.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class GenreNaviListAdapter extends BaseAdapter{
	
	private List<String> genreList = new ArrayList<>(); 

	
	public GenreNaviListAdapter(List<String> genreList) {
		super();
		this.genreList = genreList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return genreList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return genreList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = holder.button = new Button(parent.getContext());
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.button.setText(genreList.get(position));
		return convertView;
	}
	
	class ViewHolder{
		TextView button;
	}

}
