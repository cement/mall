package com.changqing.medication.models.home;

import java.util.List;

public class MainItemData {

	private int count;
	private List<String> genres;
	//private SubItemDate subdata;
	
	public MainItemData(int count,List<String> genres) {
		super();
		this.genres = genres;
		this.count = count;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}


	public int getCount() {
		return count;
	}

	public MainItemData setCount(int count) {
		this.count = count;
		return this;
	}

}
