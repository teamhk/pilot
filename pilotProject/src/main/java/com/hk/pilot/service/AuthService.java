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
	
	public int addMembers(UserInfo userInfo) {
		if(userInfo.getCardCom() == null) {	
			int ret1 = authMapper.addMembers(userInfo);	
			int ret2 = authMapper.addPersonalPay(userInfo);
			if(ret1 ==1 && ret2 ==1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int ret3 = authMapper.addMembers(userInfo);//if문 조건절 일때 {}타고 그리고 내려와서 이것도 타 그래서 Members랑 PersonalPay 테이블에 데이터 다 들어가
			if(ret3 == 1) {
				return 1;
			} else {
				return 0;
			}
		}
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
	
	public String checkEmail(String email) {
		Members checkEmail = authMapper.checkEmail(email);
		System.out.println("checkEmail:"+checkEmail);
		if(checkEmail == null) {
			return "0";
		} else {
			return "1";
		}
	}
	
	
	public int addManager(ManagerInfo managerInfo) {
		return authMapper.addManager(managerInfo);
	}
	
	public int addStores(ManagerInfo managerInfo) {
		return authMapper.addStores(managerInfo);
	}
	
	public int addItemList(ManagerInfo managerInfo) {
		return authMapper.addItemList(managerInfo);
	}

	public int addMapData(ManagerInfo managerInfo) {
		return authMapper.addMapData(managerInfo);
	}
	
	public Members findId(Members members) {
		return authMapper.findId(members);
	}	
}
