package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.Review;

public interface ReviewMapper {
	
	public void rWrite(Review review);
	
	public void rCheckup(int orderNum);
	
	public List<Review> rList();
	

}
