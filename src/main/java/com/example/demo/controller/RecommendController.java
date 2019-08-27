package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Recommend;
import com.example.demo.model.UserCredentials;
import com.example.demo.service.RecommendService;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/apiRecommend")
public class RecommendController {

	@Autowired
	   private RecommendService service;
	@RequestMapping(value= "/apiRecommend/**", method=RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }
	


	@PostMapping("/addtoRecommend")
	   public ResponseEntity<Recommend>  addtoRecommend(@RequestBody Recommend recommend){
	       service.addtoRecommend(recommend);
	       return new ResponseEntity<Recommend>(recommend,HttpStatus.OK);
	       }
	
	@GetMapping("/displayRecommend")
	public ResponseEntity<List<Recommend>>  displayAllRecommends()
	{
		List<Recommend> recommendList=service.displayAllRecommends();
		
	return new ResponseEntity<List<Recommend>>(recommendList,HttpStatus.OK);
		
	}
	
//	@DeleteMapping("/deleteRecommend/{name}")
//	public ResponseEntity<Recommend>deleteRecommend(@RequestBody Recommend recommend ){
//	service.deleteRecommend(recommend);
//	return new ResponseEntity<Recommend>(recommend,HttpStatus.NOT_FOUND);
//
//	}
	
	@DeleteMapping("/deleteRecommends/{id}")
    public ResponseEntity<Recommend> deleteRecommend(@PathVariable int id)
{

	service.deleteRecommend(id);
	return new ResponseEntity<Recommend>(HttpStatus.OK);
}

//	@DeleteMapping("/removeRecommend/{name}")
//		public ResponseEntity<Recommend>removeRecommend(@RequestBody Recommend recommend ){
//		service.deleteRecommend(recommend);
//	return new ResponseEntity<Recommend>(recommend,HttpStatus.UNAUTHORIZED);
//
//		
//	}
}
