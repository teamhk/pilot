package com.hk.pilot.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.pilot.dto.MapData;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;

@Repository
public interface AdminMapper {
	
	public UserInfo userUpdateGet(String id);
	
	public int userUpdatePost1(UserInfo userInfo); //유저 정보 변경시 Member 테이블 수정
	
	public int userUpdatePost2(UserInfo userInfo); //유저 정보 변경시 PersonalPay 테이블 수정
	
	public int userInsertPost2(UserInfo userInfo); //유저 정보 변경시 PersonalPay 테이블 추가
	
	public Members managerUpdateGet1(String id); //업주 정보 변경시 Member 테이블 수정
	
	public List<Stores> managerUpdateGet2(String id); //업체 정보 리스트 출력
	
	public int managerUpdatePost(Members members); //업주 정보 수정
	
	public List<Stores> storeList();  //업체 리스트 출력
	
	public StoreInfo storeUpdateGet(String snum); //업체 상세 정보 출력
	
	public int storeUpdatePost1(StoreInfo storeInfo); //업체 정보 수정1 (Stores)
	
	public int storeUpdatePost2(StoreInfo storeInfo); //업체 정보 수정2 (itemList)
	
	public List<MapData> mapLoad(); //맵 정보를 실시간으로 가져오는 ajax
}
