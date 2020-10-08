package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.mapper.MainMapper;

@Service
public class MainService {
	
	@Autowired
	MainMapper mainMapper;
	
	public List<Price> priceList(){
		return mainMapper.priceList();
	}
	
	public List<Stores> storesList(){
		return mainMapper.storesList();
	}
	
	public ManagerInfo userAdr(String id) {
		return mainMapper.userAdr(id);
	}
	
//	public List<StoreInfo> itemArry(String items){
//		return mainMapper.itemArry(items);
//	}//수정
	
	public StoreInfo selectsStoreOne(String snum) {
		
		return mainMapper.selectsStoreOne(snum);
	}
	
	public void addCart(Cart cart) {
		mainMapper.addCart(cart);
	}

}
