package com.hk.pilot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.pilot.dto.Member;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@GetMapping("/add")
	public String StoreAddGet(Model model) {
		System.out.println("StoreAddGet...호출");
		return "/manager/storeAddGet";
	}
	
	@PostMapping("/add")
	public String StoreAddPost(Model model,StoreInfo storeInfo ) {
		System.out.println("StoreAddPost...호출");
		System.out.println("점포정보 잘들어왔나? =>" + storeInfo.toString());
		
		int ret = managerService.storeAdd(storeInfo);
		System.out.println("점포정보 성공적으로 DB에 등록됬나? =>" + ret);
		
		return "/manager/storeAddPost";
	}
	
	@GetMapping("/update")
	public String myStoresList(HttpServletRequest request,Model model,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println(loginMember.toString());
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("storeslist",managerService.myStoresList(loginMember.getId()));
		return "/manager/storesList";
	}
	
	@GetMapping("/updateOne")
	public String selectStoreOne(@RequestParam("snum") String snum,Model model,HttpSession session) {
		System.out.println(snum);
		StoreInfo storeInfo = managerService.selectStoreOne(snum);
		System.out.println(storeInfo.toString());
		model.addAttribute("storeInfo",storeInfo);
		return "/manager/selectStoreOne";
	}
	
	@PostMapping("/updateOne")
	public String storeUpdate(Model model,StoreInfo storeInfo ) {
		System.out.println(storeInfo.toString());
		System.out.println("StoreUpdate...호출");
		System.out.println("점포업데이트 잘들어왔나? =>" + storeInfo.toString());
		
		int ret = managerService.storeUpdate(storeInfo);
		System.out.println("점포정보 성공적으로 DB에 등록됬나? =>" + ret);
		
		return "/manager/storeUpdate";
	}
	
	@GetMapping("/delete")
	public String storeDeleteList(HttpServletRequest request,Model model,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println(loginMember.toString());
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("storeslist",managerService.myStoresList(loginMember.getId()));
		return "/manager/storesList";
	}
	
	@GetMapping("/deleteOne")
	public String selectDeleteOne(@RequestParam("snum") String snum,Model model,HttpSession session) {
		System.out.println(snum);
		StoreInfo storeInfo = managerService.selectStoreOne(snum);
		System.out.println(storeInfo.toString());
		model.addAttribute("storeInfo",storeInfo);
		return "/manager/selectDeleteOne";
	}
	
	@PostMapping("/deleteOne")
	public String storeDelete(@RequestParam("snum") String snum,Model model) {
		System.out.println("storeDelete...호출");
		//System.out.println("점포업데이트 잘들어왔나? =>" + storeInfo.toString());
		int ret = managerService.storeDelete(snum);
		System.out.println("점포정보 성공적으로 삭제 됬나? =>" + ret);
		return "/manager/storeDelete";
	}
	
	@GetMapping("/ownerUpdate")
	public String selectMemberOne(Model model,HttpSession session) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		Member owner = managerService.selectMemberOne(loginMember.getId());
		System.out.println(owner.toString());
		model.addAttribute("owner",owner);
		return "/manager/selectMemberOne";
	}
	
	@PostMapping("/ownerUpdate")
	public String ownerUpdate(Model model,Member member) {
		System.out.println("memberUpdate...호출");
		System.out.println("업주정보 잘들어갔나? =>" + member.toString());
		int ret = managerService.ownerUpdate(member);
		System.out.println("업주정보 성공적으로 수정 됬나? =>" + ret);
		return "/manager/ownerUpdate";
	}
	
	@GetMapping("/ownerDelete")
	public String ownerDeleteGet(Model model,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		Member owner = managerService.selectMemberOne(loginMember.getId());
		System.out.println("업주 정보 로드가 잘 됬나?" +owner.toString());
		model.addAttribute("owner",owner);
		return "/manager/ownerDeleteGet";
	}
	
	@PostMapping("/ownerDelete")
	public String ownerDeleterPost(@RequestParam("id") String id,Model model) {
		System.out.println("ownerDeleterPost...호출");
		//System.out.println("점포업데이트 잘들어왔나? =>" + storeInfo.toString());
		int ret = managerService.ownerDeleterPost(id);
		System.out.println("업주정보 성공적으로 삭제 됬나? =>" + ret);
		return "/manager/ownerDeleterPost";
	}
	
	@GetMapping("/process")
	public String process(HttpServletRequest request,Model model,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println(loginMember.toString());
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("storeslist",managerService.myStoresList(loginMember.getId()));
		return "/manager/storesList";
	}
	
	@GetMapping("/processOne")
	public String managerOrderList(@RequestParam("snum") String snum,Model model) {
		model.addAttribute("managerOrderList",managerService.managerOrderList(snum));
		return "/manager/managerOrderList";
	}
	
	@GetMapping("/orderInfo")
	public String managerOrderInfo(@RequestParam("orderNum") int orderNum,Model model) {
		model.addAttribute("managerOrderInfo",managerService.managerOrderInfo(orderNum));
		return "/manager/managerOrderInfo";
	}
	
	@GetMapping("/stats")
	public String stats(HttpServletRequest request,Model model,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("storeslist",managerService.myStoresList(loginMember.getId()));
		return "/manager/storesList";
	}
	
	@GetMapping("/statsOne")
	public String managerStatsOne(@RequestParam("snum") String snum,Model model) {
		model.addAttribute("managerStatsOne",managerService.managerStatsOne(snum));
		return "/manager/managerStatsOne";
	}
	
		
}
