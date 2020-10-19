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

	public int addPersonalPay(UserInfo userInfo);
		
	public Members checkId(@Param("id") String id);
	
	public Members checkEmail(String email);
	
	public int addMembers(UserInfo userInfo);
	
	public int addManager(ManagerInfo managerInfo);
	
	public int addStores(ManagerInfo managerInfo);
	
	public int addItemList(ManagerInfo managerInfo);
	
	public int addMapData(ManagerInfo managerInfo);
	
	public int addEmailCheck(EmailCheck emailCheck);
	
	public String getDbCode(String email);
	
	public Members findId(Members members);
	
	public int updateRandomPwd(Members members);
	
	public void uploadAjaxPost(Stores stores);
}
