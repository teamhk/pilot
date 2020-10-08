package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.OrderProcess;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.UserInfo;

public interface UserMapper {
	
	public Members selectUserOne(String id);//user호출
	
	public PersonalPay selectUserPay(String id) ;
	
	public int userUpdate(UserInfo userInfo);//회원의 개인정보 수정
	
	public int payUpdate(UserInfo uerInfo);//회원의 카드정보수정
	
	public Members deleteUserOne(String id);//user탈퇴
	public int userDeleterPost(String id);//
	
	public List<Bubble> bubbleList(String id);//버블내역

	public List<OrderList> orderList(String id);
	
	public OrderProcess myOrderList(int orderNum);
	
}
