package com.hk.pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.Notice;
import com.hk.pilot.dto.PageMaker;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.service.SupportService;

@Controller
@RequestMapping("/support")
public class SupportController {
	
	@Autowired
	SupportService supportService;
	
	@GetMapping(value="/notice")
	public String noticeList(SearchCriteria scri, Model model) {
		System.out.println("공지사항 list 호출");

		model.addAttribute("noticeList", supportService.noticeList(scri));

		System.out.println(supportService.noticeList(scri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(scri);

		pageMaker.setTotalCount(supportService.noticeListCount(scri));

		model.addAttribute("pageMaker", pageMaker);

		return "notice/list";

	}
	
	//게시글 상세 조회
		@GetMapping(value="/noticeR")
		public String selectOne (Notice notice, Model model) {
			System.out.println("notice-selectOne 들어옴");

			model.addAttribute("selectOne", supportService.selectOne(notice.getN_seq()));
			//			       글 목록에서 댓글 보기
//			List<ChatComment> commentList = supportService.readComment(chat.getC_no());
//
//			model.addAttribute("commentList", commentList);


			return "notice/readView";
		}

}
