package com.example.demo.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserCredentials;


@Repository
public interface UserDAO extends CrudRepository<UserCredentials, String> {



	   @Query("SELECT u FROM UserCredentials u WHERE u.userName=:userName AND u.userPassword=:userPassword")
	   UserCredentials findByUserIdAndUserPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);
	

}
