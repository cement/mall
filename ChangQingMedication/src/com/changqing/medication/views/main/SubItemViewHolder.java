package com.changqing.medication.views.main;

import java.util.List;

import com.changqing.medication.main.R;
import com.changqing.medication.models.main.SubItemDate;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SubItemViewHolder extends ViewHolder {
	
	private List<SubItemDate> mSubItemDates;
	private TextView nameText;
	private ImageView imageview;
	private TextView descText;
	public SubItemViewHolder(View view, List<SubItemDate> subItemDates) {
		super(view);
		this.mSubItemDates = subItemDates;
		nameText = (TextView) view.findViewById(R.id.sub_item_name);
		imageview = (ImageView) view.findViewById(R.id.sub_item_image);
		descText = (TextView) view.findViewById(R.id.sub_item_desc);
	}
    
	public void bind(int position) {
		SubItemDate ItemData =mSubItemDates.get(position);
		nameText.setText(ItemData.getName());
		imageview.setImageDrawable(ItemData.getDrawable());
		descText.setText(ItemData.getDesc());
	}
}
