package com.example.demo.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.Exception.UserNotFoundException;

import com.example.demo.model.UserCredentials;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDAO dao;

	@Override
	public void addUser(UserCredentials userCredentials) {
		dao.save(userCredentials);
		
	}

	@Override
	public List<UserCredentials> displayAllUsers() {
		List<UserCredentials> userList=(List<UserCredentials>) dao.findAll();
		return userList;
	}

	
	  @Override
	    public UserCredentials updateUser(UserCredentials user, String id) {
	        UserCredentials u = dao.findById(id).get();
	      //  u.setUserName(user.getUserName());
	//u.setUserPassword(user.getUserPassword());
	        UserCredentials updatedBook = dao.save(user);
	        return updatedBook;
	
	
	}
	  
	  @Override
	    public UserCredentials findByUserIdAndPassword(String userName, String password) throws UserNotFoundException {
		  UserCredentials user = dao.findByUserIdAndUserPassword(userName, password);
	        if (user == null) {
	            throw new UserNotFoundException("User Not Found");
	        }
	        return user;
	    }

	

			
	


}


