package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.dto.MapData;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.Product;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.dto.StatisticDay;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;
	
	public UserInfo userUpdateGet(String id) {
		
		return adminMapper.userUpdateGet(id);
	}
	
	public List<Product> getProduct(){
		return adminMapper.getProduct();
	}
	
	public int userUpdatePost(UserInfo userInfo) {
		int ret2=0;
		int ret1=0;
		if(userInfo.getCardCheck().equals("Y")) {
			ret1 = adminMapper.userUpdatePost1(userInfo);
			ret2 = adminMapper.userUpdatePost2(userInfo);
			System.out.println("ret1="+ret1+"::::ret2="+ret2);
			if(ret1==1&&ret2==1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if(userInfo.getCardCom()!=null) {
				userInfo.setCardCheck("Y");
				ret1 = adminMapper.userUpdatePost1(userInfo);
				ret2 = adminMapper.userInsertPost2(userInfo);
				System.out.println("ret1="+ret1+"::::ret2="+ret2);
				if(ret1==1&&ret2==1) {
					return 1;
				} else {
					return 0;
				}	
			} else {
				ret1 = adminMapper.userUpdatePost1(userInfo);
				System.out.println("ret1="+ret1);
				return ret1;
			}
		}
				
	}
	
	
	public Members managerUpdateGet1(String id) {
		
		return adminMapper.managerUpdateGet1(id);
	}
	
	public List<Stores> managerUpdateGet2(String id) {
		
		return adminMapper.managerUpdateGet2(id);
	}
	
	public int managerUpdatePost(Members members) {
		
		return adminMapper.managerUpdatePost(members);
	}
	
	public List<Stores> storeList(){
		
		return adminMapper.storeList();
	}
	
	public StoreInfo storeUpdateGet(String snum) {
		return adminMapper.storeUpdateGet(snum);
	}
	
	public int storeUpdatePost(StoreInfo storeInfo) {
		int ret1 = adminMapper.storeUpdatePost1(storeInfo);
		int ret2 = adminMapper.storeUpdatePost2(storeInfo);
		if(ret1==1&&ret2==1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<MapData> mapLoad() {
		return adminMapper.mapLoad();
	}
	
	public List<Product> itemsPriceGet() {
		return adminMapper.itemsPriceGet();
	}
	
	public int insertItem(Product product) {
		return adminMapper.insertItem(product);
	}
	
	public int itemsPricePost(Product product) {
		return adminMapper.itemsPricePost(product);
	}
	
	public int deleteItem(int pno) {
		return adminMapper.deleteItem(pno);
	}

	public List<StatisticDay> chartData() {
		return adminMapper.chartData();
	}
	// 관리자 one
	public Members selectMemberOne(String id) {

		return adminMapper.selectMemberOne(id);
	}
	//  admin chat 1011 james------------------------------------------------------------------------------------------------------
	//어드민 게시글 작성
	public void write(Chat chat) {

		System.out.println("chatService-write 호출");

		System.out.println(chat.toString());

		adminMapper.write(chat);

	}

	//어드민 게시글 목록 조회
	public List<Chat> list(SearchCriteria scri){

		System.out.println("chatService-list 호출");

		return adminMapper.list(scri);
	}

	//어드민 게시물 총 개수
	public int listCount(SearchCriteria scri) {

		System.out.println("chatService-listCount 호출");

		return adminMapper.listCount(scri);
	}

	//게시물 상세 조회하기
	public Chat selectOne(int c_no) {

		System.out.println("chatService-selectOne 호출");
		return adminMapper.selectOne(c_no);
	}

	//게시글 수정

	public void update(Chat chat) {
		System.out.println("chatService-update 호출");

		System.out.println(chat.toString()+"chatService");

		adminMapper.update(chat);

	}

	//게시글 삭제하기

	public void delete(int c_no) {
		System.out.println("chatService-delete 호출");

		adminMapper.delete(c_no);

	}

	//작성 댓글 조회 -----------------------------------관리자 외 작성권한 없음 1009

	public List<ChatComment> readComment(int c_no){

		System.out.println("게시글-코멘트 읽으러 들어옴-ok");

		return adminMapper.readComment(c_no);
	}

	//댓글 작성하기
	public void writeComment(ChatComment ccment) {

		System.out.println("ccmentService -writeComment 호출");

		System.out.println(ccment.toString());

		adminMapper.writeComment(ccment);


	}



}