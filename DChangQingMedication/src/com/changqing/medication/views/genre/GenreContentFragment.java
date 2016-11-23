package com.changqing.medication.views.genre;

import java.util.List;
import java.util.Map;

import com.changqing.medication.main.R;
import com.changqing.medication.models.DataModel;
import com.changqing.medication.views.BaseViewHolder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GenreContentFragment extends Fragment {
		
	private static final String LAYOUTID = "layoutid";
	private List<DataModel> mDatas;
	public GenreContentFragment(List<DataModel> datas) {
		// TODO Auto-generated constructor stub
		this.mDatas = datas;
	}


	public static GenreContentFragment newInstance(int itemLayoutId,List<DataModel> datas) {
		GenreContentFragment fragment = new GenreContentFragment(datas);
		Bundle args = new Bundle();
		args.putInt(LAYOUTID, itemLayoutId);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//View rootView = inflater.inflate(R.layout.genre_content_item_layout, container, false);
		RecyclerView genreContent = new RecyclerView(getContext());
		genreContent.setLayoutManager(new GridLayoutManager(getContext(),2));
		genreContent.setAdapter(new ContentAdapter());
		return genreContent;
	}
	
	class ContentAdapter extends RecyclerView.Adapter<ContentViewHolder>{

		@Override
		public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View itemView = LayoutInflater.from(parent.getContext()).inflate(getArguments().getInt(LAYOUTID), parent,false);
			return new ContentViewHolder(itemView);
		}

		@Override
		public void onBindViewHolder(ContentViewHolder holder, int position) {
			holder.bind(position);
		}

		@Override
		public int getItemCount() {
			// TODO Auto-generated method stub
			return mDatas.size();
		}

		
	}
	
	class ContentViewHolder extends BaseViewHolder{
		
		TextView textView;
		TextView descView;
		ImageView imageView;

		public ContentViewHolder(View itemView) {
			super(itemView);
			assoc(itemView);
		}

		@Override
		public void bind(int position) {
			// TODO Auto-generated method stub
			textView.setText(mDatas.get(position).name+"£º "+position);
			descView.setText(mDatas.get(position).desc+"£º "+position);
			
		}

		@Override
		public void assoc(View view) {
			// TODO Auto-generated method stub
			textView = (TextView) view.findViewById(R.id.genre_content_item_name);
			descView = (TextView) view.findViewById(R.id.genre_content_item_desc);
			//imageView = (ImageView) view.findViewById(R.id.genre_content_item_image);
		}
		
	}

}