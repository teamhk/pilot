package com.hk.pilot.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.OrderProcess;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.mapper.UserMapper;


@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public Members selectUserOne(String id) {
		
		return userMapper.selectUserOne(id);
	}
	
	public PersonalPay selectUserPay(String id) {
		return userMapper.selectUserPay(id);
	}

	// user 개인정보 수정
	public int userUpdate(UserInfo userInfo) {
		int ret1 = userMapper.userUpdate(userInfo); 
		int ret2 = userMapper.payUpdate(userInfo);
		System.out.println("ret1="+ret1+", ret2="+ret2);
		if(ret1==1 && ret2==1) {
			return 1;
		} else {
			return 0; 
		} 
	}
	

	
	//user 탈퇴
	
	public Members deleteUserOne(String id) {
		
		return userMapper.deleteUserOne(id);
	}
	
	public int userDeleterPost(String id) {
		return userMapper.userDeleterPost(id);
	}
	
	//버블리스트출력
	
	public List<Bubble> bubbleList(String id) {
		return userMapper.bubbleList(id);
	}
	
	//주문내역출력
	public List<OrderList> orderList(String id) {
		return userMapper.orderList(id);
	}
	
	public OrderProcess myOrderList(int orderNum) {
		return userMapper.myOrderList(orderNum);
	}
	
}
