package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Member;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.mapper.ManagerMapper;

@Service
public class ManagerService {
	
	@Autowired
	ManagerMapper managerMapper;
	
		
	public List<Member> memberList(){
		return managerMapper.memberList();
	}

	public String pwdCheck(String id, String pwd){
		System.out.println("서비스들어옴");
		Member checkMember = managerMapper.pwdCheck(id,pwd);
		System.out.println("서비스 실행완료");
		if(checkMember==null) {
			return "N";  //비번이 일치하지않음
		} else {
			return "Y";  //비번이 일치함
		}
	}
	
	
	// 업체정보 추가
	public int storeAdd(StoreInfo storeInfo) { 
		
		int ret1 = managerMapper.storeAdd(storeInfo);
		int ret2 = managerMapper.itemListAdd(storeInfo);
		if(ret1==1 && ret2==1) {
			return 1;
		} else {
			return 0; 
		}
	}
	
	// 전체 업체 리스트
	public List<Stores> myStoresList(String id) {
		
		return managerMapper.myStoresList(id);
	}
	
	// 업체 1개 상세정보
	public StoreInfo selectStoreOne(String snum) {
		
		return managerMapper.selectStoreOne(snum);
	}
	
	// 업체 정보 수정
	public int storeUpdate(StoreInfo storeInfo) {
		int ret1 = managerMapper.storeUpdate(storeInfo); 
		int ret2 = managerMapper.itemListUpdate(storeInfo);
		System.out.println("ret1="+ret1+", ret2="+ret2);
		if(ret1==1 && ret2==1) {
			return 1;
		} else {
			return 0; 
		} 
	}
	
	// 업체 정보 삭제(sdcheck=>true)
	public int storeDelete(String snum) {
		
		int ret = managerMapper.storeDelete(snum);
		 
		return ret;
	}
	
	// 업주의 개인정보 호출 + 업주 탈퇴 확인을 위한 호출
	public Member selectMemberOne(String id) {
		
		return managerMapper.selectMemberOne(id);
	}
	
	// 업주 개인정보 수정
	public int ownerUpdate(Member member) {
		return managerMapper.ownerUpdate(member);
	}
	
	// 업주 개인정보 삭제
	public int ownerDeleterPost(String id) {
		return managerMapper.ownerDeleterPost(id);
	}
}
