package com.hk.pilot.mapper;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.EmailCheck;
import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;

public interface AuthMapper {

	public int addPersonalPay(PersonalPay personalPay);
		
	public Members checkId(@Param("id") String id);
	
	public int addMembers(Members members);
	
	public int addStores(Stores stores);
	
	public int addItemList(ItemList itemList);
	
	public int addEmailCheck(EmailCheck emailCheck);
	
	public String getDbCode(String email);
	
	public Members findId(Members members);
	
	public int updateRandomPwd(Members members);
	
//	public int addJoinCode(String joinCode);
//	
//	public int addEmail(String email);
}
