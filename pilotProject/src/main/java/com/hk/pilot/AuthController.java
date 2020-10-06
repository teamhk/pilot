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
		return "/auth/choiceMemberType";
	}
	
	@GetMapping("/addCustomer")
	public String addMemberGet(Members member) {
		return "/auth/addMember";
	} 
	
	@PostMapping("/addCustomer")
	public String addCustomerPost(Model model, UserInfo userInfo) {
		System.out.println("userInfo는"+userInfo);
		authService.addMember(userInfo);
		return "redirect:/";
	}
	
	@GetMapping("/addOwner")
	public String addOwnerGet(Members member) {
		return "/auth/addOwner";
	}
	
	@PostMapping("/addOwner")
	public String addOwnerPost(Model model, ManagerInfo managerInfo) {
		authService.addOwner(managerInfo);
		return "redirect:/";
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
