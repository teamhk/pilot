package com.hk.pilot.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.FinalPay;
import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.Product;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
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
//	
//	public ItemList itemArry(String items){
//		return mainMapper.itemArry(items);
//	}//수정
	
	public StoreInfo selectsStoreOne(String snum) {
		
		return mainMapper.selectsStoreOne(snum);
	}
	
	public List<Product> price(){
		return mainMapper.price();
	}

	public int insert(Cart cart) {
		// TODO Auto-generated method stub
		return mainMapper.insert(cart);
		
	}
	//장바구니 상품확인 
	public int countCart(int cart_seq) {
		return mainMapper.countCart(cart_seq);
	}
	
	public List<Cart> userCart(String id) { //카트
		return mainMapper.userCart(id);
	}
	
	public int cartPrice(List<Integer> cart_seq){
		for(int i=0;i<cart_seq.size();i++) {
//			System.out.println("cart_seq="+cart_seq.get(i));
		 int ret = mainMapper.cartPrice(cart_seq.get(i));
//		 System.out.println("ret"+i+"="+ret);
		}
		return 1;
	}
	//장바구니 삭제
	public void deleteCart(int cart_seq) {
		 mainMapper.deleteCart(cart_seq);
		
	}
	
	public FinalPay userPay(String id) {
		return mainMapper.userPay(id);
		
	}

	public List<FinalPay> cartpay (String id){
		
		return mainMapper.cartpay(id);
	}
	

	//버블충전
	public int bubblePay(Bubble bubble) {
		
		return mainMapper.bubblePay(bubble);
	}

	public int bubbleplus(Bubble bubble) {
		
		return mainMapper.bubbleplus(bubble);
	}
	
	//최종결제
	public int finalPay(int pay_price,@RequestParam("items[]") String[] items,@RequestParam("snum[]") String[] snum,@RequestParam("sname[]") String[] sname,int bubble,String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
	for(int i=0;i<items.length;i++) {
		Date now = new Date();
        SimpleDateFormat vans = new SimpleDateFormat("yyyyMMdd");
		String wdate = vans.format(now);
		int randomCode = new Random().nextInt(10000)+1000;
		String joinCode = String.valueOf(randomCode);
		String num=wdate+joinCode;
		double orderNum=Double.valueOf(num);
		map.put("pay_price",pay_price);
		map.put("items",items[i]);
		map.put("snum",snum[i]);
		map.put("sname",sname[i]);
		map.put("bubble",bubble);
		map.put("id", id);
		map.put("orderNum", orderNum);
		mainMapper.finalPay(map);
		System.out.println(map);
	}
		
		return 0;
	}
	
	public int bubblefinal(Bubble bubble1) {
		
		return mainMapper.bubblefinal(bubble1);
	}
	
 
	
}
