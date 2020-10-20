package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Review;
import com.hk.pilot.mapper.ReviewMapper;

@Service
public class ReviewService {
	
	@Autowired
	ReviewMapper reviewMapper;
	
	public void rWrite(Review review) {
		reviewMapper.rWrite(review);
		
	}
	
	public List<Review> rList(){
		return reviewMapper.rList();
	}
	

}
