package com.hk.pilot.mapper;

import java.util.ArrayList;
import java.util.List;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.FinalPay;
import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.Product;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;

public interface MainMapper {
	
	public List<Price> priceList();
	
	public List<Stores> storesList();
	
	public ManagerInfo userAdr(String id);
	
	//public ItemList itemArry(String items);
	
	public StoreInfo selectsStoreOne(String snum);
	
	public List<Product> price();
	
	public int insert(Cart Cart);
	
	//public List<CartPrice> myCart();
	
	public List<Cart> userCart(String id);
	
	public int cartPrice(Integer cart_seq);

	public FinalPay userPay(String id);
	
	public List<FinalPay> cartpay (String id);
	
	public int bubblePay(Bubble bubble);
	
	public int bubbleplus(Bubble bubble);
	

}
