package com.hk.pilot.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hk.pilot.dto.Account;
import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.FinalPay;
import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.Product;
import com.hk.pilot.dto.Review;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;

public interface MainMapper {
	
	public List<Price> priceList();
	
	public List<Stores> storesList();
	
	public ManagerInfo userAdr(String id);
	
	//public ItemList itemArry(String items);
	
	public StoreInfo selectsStoreOne(String snum);
	
	public Members selectLikeStore(@Param("id") String id); //likeStore 1,2,3에 값 있나 없나 조회

	public int updateLikeStore1(@Param("id") String id, @Param("snum") String snum);
	
	public int updateLikeStore2(@Param("id") String id, @Param("snum") String snum);
	
	public int updateLikeStore3(@Param("id") String id, @Param("snum") String snum);
	
	public int deleteLikeStore1(@Param("id") String id, @Param("snum") String snum);
	
	public int deleteLikeStore2(@Param("id") String id, @Param("snum") String snum);
	
	public int deleteLikeStore3(@Param("id") String id, @Param("snum") String snum);
	
	public List<Product> price();
	
	public int insert(Cart Cart);
	
	public int countCart(int cart_seq);
	
	public List<Cart> userCart(String id);
	
	public int cartPrice(@Param("seq") int seq,@Param("choice") String choice);
	
	public void deleteCart(int cart_seq);

	public FinalPay userPay(String id);
	
	public List<FinalPay> cartpay (String id);
	
	public int bubblePay(Bubble bubble);
	
	public int bubbleplus(Bubble bubble);
	
	public int accpay(Account account); //accont 초기값 가져오기
	
	public int bubAcc(Account account);
	
	//public int finalPay(int pay_price,String items,String snum,String sname,int bubble);

	public int finalPay(HashMap<String, Object> map);
	
	public int cartChk(String id);

	public int bubblefinal(Bubble bubble1);
	
	public int orderAcc(Account account);
	
	public List<OrderList> payCheck(@Param("id") String id,@Param("ret") int ret);
	
	// review 1015 james-----------------------------------------------------------------------

	public List<Review> reviewList(String snum);
	
}
