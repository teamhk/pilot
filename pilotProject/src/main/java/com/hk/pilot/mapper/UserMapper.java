package com.hk.pilot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.OrderProcess;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.dto.UserInfo;

public interface UserMapper {
	
	public Members selectUserOne(String id);//user호출
	
	public PersonalPay selectUserPay(String id); //카드정보 가져오기
	
	public int userUpdate(UserInfo userInfo);//회원의 개인정보 수정
	
	public int payUpdate(PersonalPay personalPay);//회원의 카드정보수정
	
	public Members deleteUserOne(String id);//user탈퇴
	
	public int userDeleterPost(Members members);//
	
	public List<Bubble> bubbleList(String id);//버블내역

	public List<OrderList> orderList(String id);
	
	public OrderProcess myOrderList(int orderNum);
//  1013 chat--------------------------------------------------------------------------------------------------------------------------------
	
	public void write(Chat chat); //문의게시판 게시글작성
	
	public List<Chat> list( @Param("cri")SearchCriteria cri, @Param("logId")String lodId); //게시글 목록 조회
	
	public int listCount(SearchCriteria scri); //게시글 총 개수
	
	public Chat selectOne(int c_no); //게시글 상세보기

	public void update(Chat chat); // 게시글 수정하기
	
	public void delete(int c_no); // 게시글 삭제하기
	
//	1013 chatComment--------------------------------------------------------------------------------------------------------------------------
	
	public List<ChatComment> readComment(int c_no); //작성 댓글 조회
			
}
