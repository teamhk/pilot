package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.MapData;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
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
	
	public Price itemsPriceGet() {
		return adminMapper.itemsPriceGet();
	}
	
	public int itemsPricePost(Price price) {
		return adminMapper.itemsPricePost(price);
	}
}
