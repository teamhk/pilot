package com.hk.pilot;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

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
	  public int bubblePay(int b_price,HttpSession session,Bubble bubble) {
		  System.out.println(b_price);
		  Members loginMember = (Members) session.getAttribute("loginMember");
	 		  
		  bubble.setId(loginMember.getId());
		  int bu=mainService.bubbleplus(bubble);
		  System.out.println(bu);
		  bubble.setB_price(b_price);
		  bubble.setB_bubble((int) (b_price*1.1));
		  bubble.setBubble((int)(bu+(b_price*1.1)));
		  
		  return mainService.bubblePay(bubble);
		}
	 
	  @RequestMapping(path = "/finalPay", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE )
	  public int finalPay(int pay_price,HttpSession session,OrderList orderList, @RequestParam("payData") List<String> payData) throws UnsupportedEncodingException  {
//		  @RequestParam("payData") List<String> payData
		  URLDecoder.decode("payData", "UTF-8");
		  Members loginMember = (Members) session.getAttribute("loginMember");
		  orderList.setId(loginMember.getId());
		  orderList.setPay_price(pay_price);
		  System.out.println(payData);
		
		  System.out.println(loginMember.getId());
		  
		  return mainService.finalPay(orderList,payData);
	  }
}
