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

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PageMaker;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.dto.StoreInfo;
import com.hk.pilot.service.ManagerService;
import com.hk.pilot.service.UserService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	UserService userService;

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
		Members loginMember = (Members) session.getAttribute("loginMember");
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
		Members loginMember = (Members) session.getAttribute("loginMember");
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

		Members loginMember = (Members) session.getAttribute("loginMember");
		Members owner = managerService.selectMemberOne(loginMember.getId());
		System.out.println(owner.toString());
		model.addAttribute("owner",owner);
		return "/manager/selectMemberOne";
	}

	@PostMapping("/ownerUpdate")
	public String ownerUpdate(Model model,Members members) {
		System.out.println("memberUpdate...호출");
		System.out.println("업주정보 잘들어갔나? =>" + members.toString());
		int ret = managerService.ownerUpdate(members);
		System.out.println("업주정보 성공적으로 수정 됬나? =>" + ret);
		return "/manager/ownerUpdate";
	}

	@GetMapping("/ownerDelete")
	public String ownerDeleteGet(Model model,HttpSession session) {
		Members loginMember = (Members) session.getAttribute("loginMember");
		Members owner = managerService.selectMemberOne(loginMember.getId());
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
		Members loginMember = (Members) session.getAttribute("loginMember");
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
		Members loginMember = (Members) session.getAttribute("loginMember");
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("storeslist",managerService.myStoresList(loginMember.getId()));
		return "/manager/storesList";
	}

	//	@GetMapping("/statsOne")
	//	public String managerStatsOne(@RequestParam("snum") String snum,Model model) {
	//		model.addAttribute("managerStatsOne",managerService.managerStatsOne(snum));
	//		 
	//		return "/manager/managerStatsOne";
	//	}

	//  Chat --------------------------------------------------------------------------------------
	
	//게시글 작성화면
	@GetMapping(value="/aChatW")
	public String writeGet() {
		System.out.println("글작성 페이지 호출");


		return "chat/writeView";
	}

	//게시글 작성 - db저장
		@PostMapping(value="/aChatW")
		public String writePost(Model model, Chat chat, HttpSession session) {
			System.out.println("글작성");
			
			Members loginMember = (Members) session.getAttribute("loginMember");
			Members user = userService.selectUserOne(loginMember.getId());

			model.addAttribute("user",user);
			
			managerService.write(chat);
			return "redirect:/manager/aChat";
	}

	//게시글 목록 조회
	@GetMapping(value="/aChat")
	public String list(SearchCriteria scri, Model model) {
		System.out.println("목록 조회 list 호출");
		model.addAttribute("list", managerService.list(scri));

		System.out.println(managerService.list(scri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(scri);

		pageMaker.setTotalCount(managerService.listCount(scri));

		model.addAttribute("pageMaker", pageMaker);

		return "chat/list";

	}

	//게시글 상세 조회
	@GetMapping(value="/aChatR")
	public String selectOne (Chat chat, Model model) {
		System.out.println("selectOne 들어옴");

		model.addAttribute("selectOne", managerService.selectOne(chat.getC_no()));
		//			       글 목록에서 댓글 보기
		//				List<ChatComment> commentList = ccmentService.readComment(chat.getC_no());
		//				
		//				model.addAttribute("commentList", commentList);


		return "chat/readView";
	}

	//게시글 수정 화면
	@GetMapping(value="/aChatU")
	public String updateGet(Chat chat, Model model) {
		System.out.println("updateGet 들어옴");

		model.addAttribute("update", managerService.selectOne(chat.getC_no()));

		return "chat/updateView";
	}

	//게시글 수정 - db저장
	@PostMapping(value="/aChatU")
	public String updatePost(Chat chat) {
		System.out.println("update 들어옴");

		managerService.update(chat);

		System.out.println(chat.toString() + "chatCon");

		return "redirect:/manager/aChat";

	}

	//게시글 삭제 - db저장
	@PostMapping(value="/aChatD")

	public String delete(Chat chat) {
		System.out.println("delete 들어옴");

		managerService.delete(chat.getC_no() );

		System.out.println("delete 반환");

		return "redirect:/manager/aChat";
	}

	//			//게시글 - 댓글달기
	//			@PostMapping(value="/ahcatCom")
	//			
	//			public String writeCommentPost(ChatComment ccment) {
	//				
	//				System.out.println("commentWrite-con 들어옴");
	//				
	//				ccmentService.writeComment(ccment);
	//				
	//				return "redirect:/chat/list";
	//					
	//			}


}
