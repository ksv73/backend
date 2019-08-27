package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Recommend;

public interface RecommendService {

	public void addtoRecommend(Recommend recommend);

	public List<Recommend> displayAllRecommends();

	
	
	//public void removeRecommend(Recommend recommend);

	public void deleteRecommend(int id);


	
}
