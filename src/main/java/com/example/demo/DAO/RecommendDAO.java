package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recommend;
import com.example.demo.model.UserCredentials;

@Repository
public interface RecommendDAO extends CrudRepository<Recommend, Integer> {

	
	  @Query("SELECT r FROM Recommend r where r.username=:username")
	   List<Recommend> findByUserName(@Param("username") String userName);
	
}
