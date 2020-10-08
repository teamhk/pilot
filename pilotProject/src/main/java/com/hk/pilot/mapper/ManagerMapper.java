package com.hk.pilot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderProcess;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;

public interface ManagerMapper {
	
	public List<Members> memberList();
	
	public Members pwdCheck(@Param("id") String id,@Param("pwd") String pwd);

	public int storeAdd(StoreInfo storeInfo); //1-1 업체정보 추가

	public int itemListAdd(StoreInfo storeInfo); //1-2 아이템 리스트 추가
	
	public List<Stores> myStoresList(String id); // 2 업체리스트

	public StoreInfo selectStoreOne(String Snum); // 3 업체1개 상세정보
	
	public int storeUpdate(StoreInfo storeInfo); // 3-1 업체1개 정보 수정
	
	public int itemListUpdate(StoreInfo storeInfo); // 3-2 업체1개 품목 수정
	
	public int storeDelete(String snum);  // 4 업체 정보 삭제처리
	
	public Members selectMemberOne(String id); // 5-1 업주의 개인정보 호출
	
	public int ownerUpdate(Members members); // 5-2 업주의 개인정보 수정
	
	public int ownerDeleterPost(String id); // 6 업주 개인정보 삭제
	
	public List<OrderProcess> managerOrderList(String snum); // 7-1 업체 주문정보 조회
	
	public OrderProcess managerOrderInfo(int orderNum); // 7-2 업체 주문 정보 상세보기
	
	public int managerProcess(@Param("orderNum") int orderNum,@Param("process") String process); // 8 업체 주문 상태 실시간업데이트 (myBatis 동적쿼리)
//  chat--------------------------------------------------------------------------------------------------------------------------------
	
	public void write(Chat chat); //문의게시판 게시글작성
	
	public List<Chat> list(SearchCriteria cri); //게시글 목록 조회
	
	public int listCount(SearchCriteria scri); //게시글 총 개수
	
	public Chat selectOne(int c_no); //게시글 상세보기

	public void update(Chat chat); // 게시글 수정하기
	
	public void delete(int c_no); // 게시글 삭제하기
	
			
}
