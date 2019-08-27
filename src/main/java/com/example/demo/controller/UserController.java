package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.UserNotFoundException;

import com.example.demo.model.UserCredentials;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/apiBook")
public class UserController {
	
	@Autowired
	   private UserService service;
	  
	@RequestMapping(value= "/apiBook/**", method=RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }

	
	@PostMapping("/addUser")
	   public ResponseEntity<UserCredentials>  addUser(@RequestBody UserCredentials userCredentials){
	       service.addUser(userCredentials);
	       return new ResponseEntity<UserCredentials>(userCredentials,HttpStatus.OK);
	       }
	@GetMapping("/displayAllUsers")
	public ResponseEntity<List<UserCredentials>>  displayAllUsers()
	{
		List<UserCredentials> userList=service.displayAllUsers();
		
	return new ResponseEntity<List<UserCredentials>>(userList,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateUser/{id}")
    public ResponseEntity<?>  updateUser(@PathVariable String id,@RequestBody UserCredentials userCredentials) throws UserNotFoundException{
        service.updateUser(userCredentials,id);
		return new ResponseEntity<UserCredentials>(HttpStatus.OK);
        
	}    
	
	
	
	
	
	
	@PostMapping("/login")
    public ResponseEntity<?> validate(HttpSession session,@RequestBody UserCredentials user)throws UserNotFoundException {
        //String view = "error";
        UserCredentials found = service.findByUserIdAndPassword(user.getUserName(), user.getUserPassword());
        if (found !=null) {
        	String jwtToken=generateToken(user);
        	user.setToken(jwtToken);
        	System.out.println(jwtToken);
           // session.setAttribute("userId", user.getUserName());
        	System.out.println("successfully");
            return new ResponseEntity<UserCredentials>(user,HttpStatus.OK);
           
        } else
        {
        	
        return new ResponseEntity<String>("Unauthorised",HttpStatus.UNAUTHORIZED);
    }
	}


	private String generateToken(UserCredentials user) {
		String jwtToken=Jwts.builder().setId(user.getUserName()).
				setSubject(user.getUserName()).
				setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secretkey").
				compact();	
				return jwtToken;
	}


	
		

}
