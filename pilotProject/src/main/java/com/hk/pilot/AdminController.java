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

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PageMaker;
import com.hk.pilot.dto.Price;
import com.hk.pilot.dto.Product;
import com.hk.pilot.dto.SearchCriteria;
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
		
		@GetMapping("/storeList")
		public String storeList(Model model) {
			System.out.println("storeList....호출...");
			model.addAttribute("stores",adminService.storeList());
			return "/admin/storeList";
		}
		
		@GetMapping("/storeUpdate")
		public String storeUpdateGet(Model model,@RequestParam("snum") String snum) {
			
			model.addAttribute("storeInfo",adminService.storeUpdateGet(snum));
			System.out.println(adminService.storeUpdateGet(snum).toString());
			List<Product> product = adminService.getProduct();
			model.addAttribute("product",product);
			System.out.println(product.toString());
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
			List<Product> itp = adminService.itemsPriceGet();
			System.out.println(itp.toString());
			model.addAttribute("itp",itp);
			return "/admin/itemsPriceGet";
		}
		
		@PostMapping("/price")
		public String itemsPricePost(Model model,Product product) {
			System.out.println("pricePost...호출");
			System.out.println(product);
			int ret = adminService.itemsPricePost(product);
			return "admin/itemsPricePost";
		}
		
		@GetMapping("/stat")
		public String statList(Model model) {
			System.out.println("statList....호출...");
			model.addAttribute("stores",adminService.storeList());
			return "/admin/statList";
		}
		
		@GetMapping("/statOne")
		public String statOne(Model model,@RequestParam("snum") String snum) {
			System.out.println("statOne....호출...");
			model.addAttribute("snum",snum);
			return "/admin/statOne";
		}
		
		@GetMapping("/assets")
		public String assetList(Model model) {
			System.out.println("assetList....호출...");
			model.addAttribute("stores",adminService.storeList());
			return "/admin/assetList";
		}
		
		@GetMapping("/assetOne")
		public String assetOne(Model model,@RequestParam("snum") String snum) {
			System.out.println("assetOne....호출...");
			model.addAttribute("asset",adminService.assetOne(snum));
			System.out.println(adminService.assetOne(snum).toString());
			return "/admin/assetOne";
		}
		
		
		//--------------chat---------------------------------------------------------------------------------------------------------------------------------------------

		@GetMapping("/adminUpdate")
		public String selectMemberOne(Model model,HttpSession session) {

			Members loginMember = (Members) session.getAttribute("loginMember");
			Members admin = adminService.selectMemberOne(loginMember.getId());
			System.out.println(admin.toString());
			model.addAttribute("admin",admin);
			return "/admin/selectMemberOne";
		}

		//  Chat --------------------------------------------------------------------------------------

		//어드민 게시글 작성화면 101 수정 james
		@GetMapping(value="/aChatW")
		public String writeGet() {
			System.out.println("admin 글작성 페이지 호출");


			return "chat/aWriteView";
		}

		//어드민 게시글 작성 - db저장
		@PostMapping(value="/aChatW")
		public String writePost(Model model, Chat chat, HttpSession session) {
			System.out.println("글작성");

			Members loginMember = (Members) session.getAttribute("loginMember");

			System.out.println("admin 여기는 들어오지?");

			Members admin = adminService.selectMemberOne(loginMember.getGrade());

			System.out.println("회원등급은" + loginMember.getGrade());

			model.addAttribute("admin",admin);

			System.out.println("admin 여기도 오니?");

			adminService.write(chat);
			return "redirect:/admin/aChat";
		}

		//어드민 게시글 목록 조회
		@GetMapping(value="/aChat")
		public String list(SearchCriteria scri, Model model) {
			System.out.println("목록 조회 list 호출");
			model.addAttribute("list", adminService.list(scri));

			System.out.println(adminService.list(scri));

			PageMaker pageMaker = new PageMaker();

			pageMaker.setCri(scri);

			pageMaker.setTotalCount(adminService.listCount(scri));

			model.addAttribute("pageMaker", pageMaker);

			return "chat/aList";

		}

		//게시글 상세 조회 -댓글 목록 조회 가능(조회만 가능) james
		@GetMapping(value="/aChatR")
		public String selectOne (Chat chat, Model model) {
			System.out.println("selectOne 들어옴");

			model.addAttribute("selectOne", adminService.selectOne(chat.getC_no()));
			//			       글 목록에서 댓글 보기
			List<ChatComment> commentList = adminService.readComment(chat.getC_no());

			model.addAttribute("commentList", commentList);


			return "chat/aReadView";
		}

		//게시글 수정 화면
		@GetMapping(value="/aChatU")
		public String updateGet(Chat chat, Model model) {
			System.out.println("updateGet 들어옴");

			model.addAttribute("update", adminService.selectOne(chat.getC_no()));

			return "chat/aUpdateView";
		}

		//게시글 수정 - db저장
		@PostMapping(value="/aChatU")
		public String updatePost(Chat chat) {
			System.out.println("update 들어옴");

			adminService.update(chat);

			System.out.println(chat.toString() + "chatCon");

			return "redirect:/admin/aChat";

		}

		//게시글 삭제 - db저장
		@PostMapping(value="/aChatD")

		public String delete(Chat chat) {
			System.out.println("delete 들어옴");

			adminService.delete(chat.getC_no() );

			System.out.println("delete 반환");

			return "redirect:/admin/aChat";
		}

		//게시글 - 댓글달기 1009추가 james(관리자만 작성으로 미 구현)

		@PostMapping(value="/aChatCom")

		public String writeCommentPost(ChatComment ccment) {

			System.out.println("commentWrite-con 들어옴");

			adminService.writeComment(ccment);

			return "redirect:/admin/aChat";

		}

	}
