package com.hk.pilot.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.FinalPay;
import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
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
	
	public int countCart(int cart_seq);
	
	public List<Cart> userCart(String id);
	
	public int cartPrice(Integer cart_seq);
	
	public void deleteCart(int cart_seq);

	public FinalPay userPay(String id);
	
	public List<FinalPay> cartpay (String id);
	
	public int bubblePay(Bubble bubble);
	
	public int bubbleplus(Bubble bubble);
	
	//public int finalPay(int pay_price,String items,String snum,String sname,int bubble);

	public int finalPay(HashMap<String, Object> map);

	public int bubblefinal(Bubble bubble1);
}
