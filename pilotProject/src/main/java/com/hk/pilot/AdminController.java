package com.hk.pilot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.service.AdminService;
import com.hk.pilot.service.ManagerService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
		@Autowired
		ManagerService managerService;
		
		@Autowired
		AdminService adminService;
		
		@GetMapping("/memberList")
		public String memberList(Model model) {
			System.out.println("memberList...호출");
			model.addAttribute("memberList",managerService.memberList());
			return "/admin/memberList";
		}

		@GetMapping("/userUpdate")
		public String userUpdateGet(Model model,@RequestParam("id") String id) {
			System.out.println("UserUpdate...호출");

			UserInfo userInfo = adminService.userUpdateGet(id);
			
			System.out.println(userInfo.toString());
			model.addAttribute("userInfo",userInfo);
			return "/admin/userUpdateGet";
		}
		
		@PostMapping("/userUpdate")
		public String userUpdatePost(Model model, UserInfo userInfo) {
			System.out.println("바뀐 값:"+userInfo.toString());
			int ret = adminService.userUpdatePost(userInfo);
			System.out.println("정상적으로 수정되었나? "+ret);
			return "admin/userUpdatePost";
		}
		
		@GetMapping("/managerUpdate")
		public String managerUpdateGet(Model model,@RequestParam("id") String id) {
			System.out.println("ManagerUpdate...호출");
			
			Members members = adminService.managerUpdateGet1(id);
			model.addAttribute("members",members);
			List<Stores> stores = adminService.managerUpdateGet2(id);
			model.addAttribute("stores",stores);
			
			System.out.println(members.toString());
			System.out.println(stores.toString());
			return "/admin/managerUpdateGet";
		}
		
		@PostMapping("/managerUpdate")
		public String managerUpdatePost(Model model, Members members) {
			System.out.println("바뀐 값:"+members.toString());
			int ret = adminService.managerUpdatePost(members);
			System.out.println("정상적으로 수정되었나? "+ret);
			return "admin/userUpdatePost";
		}
		
		@GetMapping("/storeInfo")
		public String storeList(Model model) {
			System.out.println("storeList....호출...");
			model.addAttribute("stores",adminService.storeList());
			return "/admin/storeList";
		}
		
		@GetMapping("/storeUpdate")
		public String storeUpdateGet(Model model,@RequestParam("snum") String snum) {
			
			model.addAttribute("storeInfo",adminService.storeUpdateGet(snum));
			System.out.println(adminService.storeUpdateGet(snum).toString());
			return "/admin/storeUpdateGet";
		}
		
		@PostMapping("/storeUpdate")
		public String storeUpdatePost(Model model,StoreInfo storeInfo ) {
			System.out.println("바뀐 값:"+storeInfo.toString());
			int ret = adminService.storeUpdatePost(storeInfo);
			System.out.println("정상적으로 수정되었나? "+ret);
			return "/admin/storeUpdatePost";
		}
		
		@GetMapping("/price")
		public String itemsPriceGet(Model model) {
			System.out.println("priceGet...호출");
			return "/admin/itemsPriceGet";
			
		}
		
}
