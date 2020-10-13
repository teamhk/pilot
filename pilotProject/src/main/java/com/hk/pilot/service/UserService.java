package com.hk.pilot.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.OrderProcess;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.SearchCriteria;
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
	// 1013 chat------------------------------------------------------------------------------------------------------
	//게시글 작성
	public void write(Chat chat) {

		System.out.println("chatService-write 호출");

		System.out.println(chat.toString());

		userMapper.write(chat);

	}

	//게시글 목록 조회
	public List<Chat> list(SearchCriteria scri, String logId){

		System.out.println("chatService-list 호출");

		return userMapper.list(scri, logId);
	}

	//게시물 총 개수
	public int listCount(SearchCriteria scri) {

		System.out.println("chatService-listCount 호출");

		return userMapper.listCount(scri);
	}

	//게시물 상세 조회하기
	public Chat selectOne(int c_no) {

		System.out.println("chatService-selectOne 호출");
		return userMapper.selectOne(c_no);
	}

	//게시글 수정

	public void update(Chat chat) {
		System.out.println("chatService-update 호출");

		System.out.println(chat.toString()+"chatService");

		userMapper.update(chat);

	}

	//게시글 삭제하기

	public void delete(int c_no) {
		System.out.println("chatService-delete 호출");

		userMapper.delete(c_no);

	}

	//작성 댓글 조회 —————————————————관리자 외 작성권한 없음 1009

	public List<ChatComment> readComment(int c_no){

		System.out.println("게시글-코멘트 읽으러 들어옴-ok");

		return userMapper.readComment(c_no);
	}


}	

