package com.changqing.medication.constom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerViewClickListener implements RecyclerView.OnItemTouchListener {

	private GestureDetector mGestureDetector;
	private OnItemClickListener mListener;

	public interface OnItemClickListener {
		void onItemClick(View view, int position);

		void onItemLongClick(View view, int position);
	}

	public RecyclerViewClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
		mListener = listener;
		mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // ����ѡ��SimpleOnGestureListenerʵ���࣬���Ը�����Ҫѡ����д�ķ���
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
				if (childView != null && mListener != null) {
					mListener.onItemClick(childView, recyclerView.getChildLayoutPosition(childView));
					return true;
				}
				return false;
			}

			// �����¼�
			@Override
			public void onLongPress(MotionEvent e) {
				View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
				if (childView != null && mListener != null) {
					mListener.onItemLongClick(childView, recyclerView.getChildLayoutPosition(childView));
				}
			}
		});
	}

	@Override
	public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
		// ���¼�����GestureDetector����
		if (mGestureDetector.onTouchEvent(e)) {
			return true;
		} else
			return false;
	}

	@Override
	public void onTouchEvent(RecyclerView rv, MotionEvent e) {
	}

	@Override
	public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
	}
}