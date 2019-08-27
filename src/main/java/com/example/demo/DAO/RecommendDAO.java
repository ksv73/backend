package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recommend;

@Repository
public interface RecommendDAO extends CrudRepository<Recommend, Integer> {

}
