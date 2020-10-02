package com.hk.pilot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.Member;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;

public interface ManagerMapper {
	
	public List<Member> memberList();
	
	public Member pwdCheck(@Param("id") String id,@Param("pwd") String pwd);

	public int storeAdd(StoreInfo storeInfo); //1-1 업체정보 추가

	public int itemListAdd(StoreInfo storeInfo); //1-2 아이템 리스트 추가
	
	public List<Stores> myStoresList(String id); // 2 업체리스트

	public StoreInfo selectStoreOne(String Snum); // 3 업체1개 상세정보
	
	public int storeUpdate(StoreInfo storeInfo); // 3-1 업체1개 정보 수정
	
	public int itemListUpdate(StoreInfo storeInfo); // 3-2 업체1개 품목 수정
	
	public int storeDelete(String snum);  // 4 업체 정보 삭제처리
	
	public Member selectMemberOne(String id); // 5-1 업주의 개인정보 호출
	
	public int ownerUpdate(Member member); // 5-2 업주의 개인정보 수정
	
	public int ownerDeleterPost(String id); // 6 업주 개인정보 삭제
}
