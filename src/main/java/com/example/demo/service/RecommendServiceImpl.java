package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.RecommendDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Recommend;
import com.example.demo.model.UserCredentials;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired 
	private RecommendDAO dao;

	@Override
	public void addtoRecommend(Recommend recommend) {
		dao.save(recommend);
	}

	@Override
	public List<Recommend> displayAllRecommends() {
		 	List<Recommend> recommendList=(List<Recommend>)
		 			dao.findAll();
		return recommendList;
	}

	@Override
	public void deleteRecommend(int id) {
		dao.deleteById(id);
		
	}

	


		
	
	
//	public void deleteRecommend(Recommend recommend) {
//		dao.delete(recommend);
//	}
//	public void removeRecommend(Recommend recommend) {
//		dao.delete(recommend);
//	}
	

}
