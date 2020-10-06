package com.hk.pilot.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.mapper.AuthMapper;

@Service
public class AuthService {

	@Autowired
	AuthMapper authMapper;
	
	public int addMember(UserInfo userInfo) {
		return authMapper.addMember(userInfo);
	}

	public String checkId(String id) {
		Members checkId = authMapper.checkId(id);
		System.out.println("checkId"+checkId);
		if(checkId==null) {
			//디비에서 가지고 온게 없어, id가 일치한게 없어 그럼 사용 가능
			return "0";
		} else {
			//디비에서 가져온게 있어, 일치한게 있는거야 사용 불가!
			return "1";
		}
	}
	
	public int addOwner(ManagerInfo managerInfo) {
		return authMapper.addOwner(managerInfo);
	}

	
}
