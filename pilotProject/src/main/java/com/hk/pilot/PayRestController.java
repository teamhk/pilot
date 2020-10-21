package com.hk.pilot;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hk.pilot.dto.Account;
import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.service.MainService;

@RestController
@RequestMapping(path="/order", produces="text/plain;charset=UTF-8")
public class PayRestController {
	@Autowired
	MainService mainService;
	
	
	  @RequestMapping(path = "/bubblePay", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE )
	  public int bubblePay(int b_price,HttpSession session,Bubble bubble,Account account) {
		  System.out.println(b_price);
		  Members loginMember = (Members) session.getAttribute("loginMember");
	 		  
		  bubble.setId(loginMember.getId());
		  int bu=mainService.bubbleplus(bubble);
		  System.out.println(bu);
		  bubble.setB_price(b_price);
		  bubble.setB_bubble((int) (b_price*1.1));
		  bubble.setBubble((int)(bu+(b_price*1.1)));
		  
		  int bal=mainService.accpay(account);
		  account.setId(loginMember.getId());
		  account.setBalance((int)(bal+b_price));
		  account.setI_price(b_price);
		  
		 
		  return mainService.bubblePay(bubble,account);
		}
	 
	  @RequestMapping(path = "/finalPay", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE )
	     public int finalPay(HttpSession session,int pay_price,@RequestParam("items[]") String[] items,@RequestParam("snum[]") String[] snum,@RequestParam("sname[]") String[] sname,int bubble,String id,Bubble bubble1,Account account){
		  Members loginMember = (Members) session.getAttribute("loginMember");
		  bubble1.setId(loginMember.getId());
		  int bu=mainService.bubbleplus(bubble1);
		  System.out.println(bu);
		   bubble1.setP_bubble(bubble);
		  	bubble1.setBubble((int)(bu-bubble));
		  	System.out.println((int)(bu-bubble));
		  	
		  	 int bal=mainService.accpay(account);
			 account.setId(loginMember.getId());
			 account.setBalance((int)(bal+pay_price));
		  account.setI_price(pay_price);
		  
		  	mainService.bubblefinal(bubble1);
		  	mainService.orderAcc(account);
	        mainService.finalPay(pay_price,items,snum,sname,bubble,id);
	        return 0;
	     }
	
}
