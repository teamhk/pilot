package com.hk.pilot;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.service.MainService;




@Controller
@RequestMapping("/stores")
public class StoresController {
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/map")
	public String storesList(Stores Stores,ManagerInfo managerInfo,Model model,HttpSession session,Members members) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		ManagerInfo user=mainService.userAdr(loginMember.getId());
		model.addAttribute("stores",mainService.storesList());
		model.addAttribute("user",user);
		return "main/storesList";
	}
	
	
	@GetMapping("/info")
	public String selectsStoreOne(String snum,Model model,StoreInfo StoreInfo) {
		StoreInfo storeInfo = mainService.selectsStoreOne(snum);
//		List<StoreInfo> item = mainService.itemArry(storeInfo.getItems());//수정
//		model.addAttribute("item",item);//수정
		model.addAttribute("storeInfo",storeInfo);
		
		return "main/storesInfo";
	}
		
//	@RequestMapping("/addcart")
//	public ModelAndView addCart(Cart cart, HttpSession session) {
//		 
//		ArrayList<Cart> cartList=
//				(ArrayList<Cart>)session.getAttribute("cartlist");
//		if(cartList==null) {
//			cartList =new ArrayList<Cart>();
//		}
//		
//		cartList.add(cart);
//		session.setAttribute("cartList", cartList);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("foward:/cartList.action");
//		
//		return mav;
//	}
		
}

