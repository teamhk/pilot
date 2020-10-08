package com.hk.pilot;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Bubble;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.OrderList;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
//
//	@GetMapping("/update")
//	public String memberUpdate (Members Member,Model model) {
//		model.addAttribute("url", );
//		
//		return "/user/memberUpdate";
//	}
	@Autowired
	UserService userService;
	
	//회원정보수정
	@GetMapping("/update")
	public String selectUserOne(Model model,HttpSession session,UserInfo uerInfo) {
		
		Members loginMember = (Members) session.getAttribute("loginMember");
		Members user = userService.selectUserOne(loginMember.getId());
		PersonalPay pay = userService.selectUserPay(loginMember.getId());
		model.addAttribute("user",user);
		model.addAttribute("pay",pay);
		return "user/selectUserOne";
	}
	
	@PostMapping("/update")
	public String userUpdate(Model model,UserInfo userInfo) {
		int ret = userService.userUpdate(userInfo);
		return "user/userUpdate";
	}
	
	//user 탈퇴
	@GetMapping("/delet")
	public String userDeleteGet(Model model,HttpSession session) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		Members user = userService.deleteUserOne(loginMember.getId());
		model.addAttribute("user",user);
		return "user/userDeleteGet";
	}
	
	@PostMapping("/delet")
	public String userDeleterPost(@RequestParam("id") String id,Model model) {
		int ret = userService.userDeleterPost(id);
		return "user/userDeleterPost";
	}
	
	//버블관리
	@GetMapping("/bubbleList")
	public String bubbleList(Model model,HttpSession session,Bubble bubble) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		model.addAttribute("bub",userService.bubbleList(loginMember.getId()));
		return "user/bubbleList";
	}
	
	//주문번호 리스트
	@GetMapping("/process")
	public String OrderList(HttpServletRequest request,Model model,HttpSession session,OrderList orderList) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("order",userService.orderList(loginMember.getId()));
		return "user/orderList";
	}
	
	//주문 상세내역
	@GetMapping("/processOne")
	public String myOrderList(@RequestParam("orderNum") int orderNum,Model model) {
		model.addAttribute("myOrderList",userService.myOrderList(orderNum));
		return "user/myOrderList";
	}
	
}
