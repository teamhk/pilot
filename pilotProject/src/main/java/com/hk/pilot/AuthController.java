package com.hk.pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@GetMapping("/registration")
	public String choiceMemberType() {
		System.out.println("타니?");
		return "/auth/choiceMemberType";
	}
	
	@GetMapping("/addCustomer")
	public String addMemberGet(Members member) {
		return "/auth/addMember";
	} 
	
	@PostMapping("/addCustomer")
	public String addCustomerPost(Model model, Members members, PersonalPay personalPay) {
		System.out.println("userInfo는"+members+personalPay);
		authService.addMembers(members);
		authService.addPersonalPay(personalPay);
		return "redirect:/";
	}
	
	@GetMapping("/addOwner")
	public String addOwnerGet(Members member) {
		return "/auth/addOwner";
	}
	
	@PostMapping("/addOwner")
	public String addOwnerPost(Model model, Members members, Stores stores, ItemList itemList) {
		System.out.println("managerInfo는"+members+stores+itemList);
		authService.addMembers(members);
		authService.addStores(stores);
		authService.addItemList(itemList);
		return "redirect:/";
	}
	
	@GetMapping("/findId")
	public String findIdGet() {
		return "/auth/findIdGet";
	}
	
	@PostMapping("/findId")
	public String findIdPost(Model model, Members members) {
		System.out.println("members에 아이디/이멜 있나 확인"+members);
		
		
		model.addAttribute("members", authService.findId(members));
		
		return "/auth/findIdPost";
	}
	
	@GetMapping("/findPwd")
	public String findPwd() {
		return "/auth/findPwd";
	}
//	@PostMapping("/addOwner")
//	public String addStores(Model model, Stores stores) {
//		authService.addStores(stores);
//		return "redirect:/";
//	}
//	
//	@PostMapping("/addOwner")
//	public String addItemList(Model model, ItemList itemList) {
//		authService.addItemList(itemList);
//		return "redirect:/";
//	}
}
