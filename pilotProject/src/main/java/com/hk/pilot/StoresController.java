package com.hk.pilot;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.hk.pilot.dto.Cart;
import com.hk.pilot.dto.FinalPay;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Product;
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
		model.addAttribute("product",mainService.price());
		return "main/storesInfo";
	}
	
	
	@PostMapping("/info")
    public String insert( Cart cart, HttpSession session) {

       
		Members loginMember=(Members)session.getAttribute("loginMember");
		
        if(loginMember==null) { 

        //로그인하지 않은 상태이면 로그인 화면으로 이동

            return "redirect:/auth/login";
        }
        cart.setId(loginMember.getId());
    
        int count =mainService.countCart(cart.getCart_seq());
        
        if(count ==0) {
        	mainService.insert(cart);
        }
        
        
//        int ret=mainService.insert(cart); //장바구니 테이블에 저장됨
//        System.out.println(ret);
        return "main/cart"; //장바구니 목록으로 이동
    }
	
	@GetMapping("/cart")
	public String addCart(Cart cart, HttpSession session,Model model,Members members) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		List<Cart> cartList=mainService.userCart(loginMember.getId());
//		 int count =mainService.countCart(cart.getCart_seq());
//		 model.addAttribute("count",count);
		model.addAttribute("cartList",cartList);
		return "main/cartList";
	}
	
	//장바구니삭제
	@RequestMapping("/delete")
		public String deleteCart(@RequestParam("cart_seq") int cart_seq ,Model model) {
		mainService.deleteCart(cart_seq);
			
			return "redirect:/stores/cart";
		}
		
		
	
	@PostMapping("/cart")
	public String UpdateCart(@RequestParam("cart_seq") List<Integer> cart_seq ,Model model) {
		//List<Cart> cartList=mainService.userCart();
		int cartPrice=mainService.cartPrice(cart_seq);
		
		
		
		return "redirect:/stores/pay";
	}
	
	
	@GetMapping("/pay")
	public String cartPay(FinalPay finalpay,HttpSession session,Model model) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		FinalPay finalPay=mainService.userPay(loginMember.getId());
		List<FinalPay> cartpay=mainService.cartpay(loginMember.getId());
		model.addAttribute("finalPay",finalPay);
		model.addAttribute("cartpay",cartpay);
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

