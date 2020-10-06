package com.hk.pilot;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.pilot.dto.Members;
import com.hk.pilot.service.MemberService;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public String loginGet(Model model) {
		return "auth/loginGet";
	}
	
	@PostMapping("/login")
	public String loginPost(HttpSession session, Model model, Members members) {
		System.out.println("타니1");
		System.out.println("members는"+members);
		Members loginMember = memberService.memberLogin(members);
		System.out.println("타니2");
		System.out.println("loginMember는:"+loginMember);
		System.out.println("name은:"+loginMember.getName());
		session.setAttribute("name", loginMember.getName());	
		boolean isLogin=loginMember!=null;
		if(isLogin) {
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		}else {
			return "/auth/loginFail";
		}
	}
	
	@GetMapping("/logout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
