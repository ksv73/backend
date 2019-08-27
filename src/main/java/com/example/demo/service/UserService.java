package com.example.demo.service;

import java.util.List;

import org.apache.catalina.User;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.model.UserCredentials;

public interface UserService {

	void addUser(UserCredentials userCredentials);

	List<UserCredentials> displayAllUsers();

	

	

	//public User findByUserIdAndPassword(String userName, String password) throws UserNotFoundException;
    public UserCredentials findByUserIdAndPassword(String userName, String password) throws UserNotFoundException, UserNotFoundException ;

	public UserCredentials updateUser(UserCredentials user, String id);

	
}
