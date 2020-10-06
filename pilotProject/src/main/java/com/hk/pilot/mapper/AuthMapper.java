package com.hk.pilot.mapper;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.UserInfo;

public interface AuthMapper {

	public int addMember(UserInfo userInfo);
		
	public Members checkId(@Param("id") String id);
	
	public int addOwner(ManagerInfo managerInfo);
}
