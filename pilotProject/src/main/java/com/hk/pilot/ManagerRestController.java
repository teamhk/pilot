package com.hk.pilot;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.pilot.dto.Members;
import com.hk.pilot.service.ManagerService;


@RestController  //화면(jsp파일명 리턴이 필요하지않다, 데이터값만 리턴)
@RequestMapping(value="/member/rest") //순수한 형태의 text로 주겠다.
public class ManagerRestController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerRestController.class);

	@Autowired
	ManagerService managerService;
	
	@GetMapping(path="/list", produces="text/plain;charset=UTF-8")
	public String memberRestList(Locale locale, Model model) {
		logger.info("/member/rest/list ----------");
		return "이건 서버에서 보내준 /member/rest/list";
	}

	@GetMapping(path = "/listjson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Members> memberRestListJson(Locale locale, Model model) {
		logger.info("/member/rest/listJson ----------");
		
		return managerService.memberList();
	}
	
	
	@GetMapping(path = "/listxml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Members> memberRestListxml(Locale locale, Model model) {
		logger.info("/member/rest/listxml ----------");
		
		return managerService.memberList();
	}

	@GetMapping(path="/addJson" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Members> memberRestAddJSon(@RequestParam("name") String name , @RequestParam("pwd") String pwd) { 
		logger.info("-----------------");
		logger.info("Client에서 보내온 값은 === " + name + ":::" + pwd);

		return managerService.memberList();
	}

	@GetMapping(path = "/pwdJson", produces = MediaType.APPLICATION_JSON_VALUE)
	public String memberRestPwdJson(@RequestParam("id") String id, @RequestParam("pwd") String pwd,Model model) {
		logger.info("/member/rest/pwdJson ----------");
		System.out.println("<<여기는 managerRestController>> id ="+ id+" :::   pwd=" + pwd);
		return managerService.pwdCheck(id, pwd);
	}
	
	@GetMapping(path = "/process", produces = MediaType.APPLICATION_JSON_VALUE)
	public int managerProcess(@RequestParam("orderNum") int orderNum, @RequestParam("process") String process,Model model) {
		logger.info("/member/rest/managerProcess ----------");
		System.out.println("<<여기는 managerRestController>>"+"주문상태 변경중입니다.");
		return managerService.managerProcess(orderNum, process);
	}

	  
//	@GetMapping(path="/adminChart", produces = MediaType.APPLICATION_JSON_VALUE)
//	    public List<StatisticDay> drawChart() {
//	        return managerService.aabbcc();
//	    }
	 
	    
	    

}
	

