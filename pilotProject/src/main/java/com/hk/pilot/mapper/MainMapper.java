package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;

public interface MainMapper {
	
	public List<Price> priceList();
	
	public List<Stores> storesList();
	
	public ManagerInfo userAdr(String id);
	
//	public List<StoreInfo> itemArry(String items);
	
	public StoreInfo selectsStoreOne(String snum);
	
	public void addCart(Cart cart);

}
