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
import com.hk.pilot.dto.FinalPay;
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
		return "/main/mapTestEnd";
	}
	
	@GetMapping("/noUserMap")
	public String noUserMap(Stores stores, ManagerInfo managerInfo, Model model) {
		return "/main/noUserMap";
	}
	
	@GetMapping("/info")
	public String selectsStoreOne(String snum,Model model,StoreInfo StoreInfo) {
		StoreInfo storeInfo = mainService.selectsStoreOne(snum);
		String item=storeInfo.getItems();
		String[] items=item.split("!@#");
		model.addAttribute("items",items);
		model.addAttribute("storeInfo",storeInfo);
		
		return "main/storesInfo";
	}
	
	
	@PostMapping("/info")
    public String insert( Cart cart, HttpSession session) {

        //Members loginMember=(Members)session.getAttribute("loginMember");
        //CartPrice id=mainService.userId(loginMember.getId());
		Members loginMember=(Members)session.getAttribute("loginMember");
		//String item=cart.getItems();
		//String items=item.join("!@#");
		//System.out.println(items);
		//CartPrice id=mainService.userId(loginMember.getId());
        //System.out.println(loginMember);
        //List<CartPrice> user=mainService.userCart(loginMember.getId());
        if(loginMember==null) { 

        //로그인하지 않은 상태이면 로그인 화면으로 이동

            return "redirect:/auth/login";
        }
        cart.setId(loginMember.getId());
    
        int ret=mainService.insert(cart); //장바구니 테이블에 저장됨
        System.out.println(ret);
        return "main/cart"; //장바구니 목록으로 이동
    }
	
	@GetMapping("/cart")
	public String addCart(Cart cart, HttpSession session,Model model,Members members) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		List<Cart> cartList=mainService.userCart(loginMember.getId());
		model.addAttribute("cartList",cartList);
		System.out.println(cartList);
		return "main/cartList";
	}
	
	@PostMapping("/cart")
	public String UpdateCart(@RequestParam("cart_seq") List<Integer> cart_seq , HttpSession session,Model model,Members members) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		List<Cart> cartList=mainService.userCart(loginMember.getId());
		int cartPrice=mainService.cartPrice(cart_seq);
		model.addAttribute("cartList",cartList);
		
		
		return "redirect:/stores/pay";
	}
	
	@GetMapping("/pay")
	public String cartPay(FinalPay finalpay,HttpSession session,Model model,Members members) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		FinalPay finalPay=mainService.userPay(loginMember.getId());
		List<FinalPay> cartpay=mainService.cartpay(loginMember.getId());
		model.addAttribute("finalPay",finalPay);
		model.addAttribute("cartpay",cartpay);
		System.out.println(cartpay);
		return "main/cartPay";
	}
	
//	@PostMapping("/bubble")
//	public String bubblePay(HttpSession session,Model model,Members members) {
//		Members loginMember = (Members) session.getAttribute("loginMember");
//		UserInfo bubblePay=mainService.bubblePay(loginMember.getId());
//		model.addAttribute("bubblePay",bubblePay);
//		
//		return "redirect:/stores/pay";
//	}
		
}

