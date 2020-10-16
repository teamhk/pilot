package com.hk.pilot;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hk.pilot.dto.ItemList;
import com.hk.pilot.dto.ManagerInfo;
import com.hk.pilot.dto.MapData;
import com.hk.pilot.dto.Members;
import com.hk.pilot.dto.PersonalPay;
import com.hk.pilot.dto.Stores;
import com.hk.pilot.dto.UserInfo;
import com.hk.pilot.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthRestController.class);

	
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
	public String addOwnerPost(@RequestParam("uploadFile") MultipartFile[] uploadFile, Model model, ManagerInfo managerInfo) {
		for(int i=0; i<uploadFile.length; i++) {
			 String uploadFolder = "C:\\upload";
			 String uploadFileName = uploadFile[i].getOriginalFilename(); 
			 logger.info("---------------------------------");
	         logger.info("Upload File Name :"+uploadFile[i].getOriginalFilename());
	         logger.info("Upload File Size : " + uploadFile[i].getSize());
	         
	       //IE has file path
	            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
	            logger.info("only file name : " + uploadFileName);
	            
	            //중복 방지를 위햔 UUID적용
	            //동일한 이름으로 업로드 되면 기존파일을 지운데 그래서 java.util.UUID의 값을 이용
	            UUID uuid = UUID.randomUUID();
	            uploadFileName = uuid.toString()+"_"+uploadFileName;
	            
	            if(i==0) {managerInfo.setSp1(uploadFileName);}
	            else if(i==1) {managerInfo.setSp2(uploadFileName);}
	            else if(i==2) {managerInfo.setSp3(uploadFileName);}
	            else if(i==3) {managerInfo.setSp4(uploadFileName);}
	           // stores.setSnum(snum);
	            
	            //File saveFile = new File(uploadFolder, uploadFileName);
	            File saveFile = new File(uploadFolder, uploadFileName);
	            System.out.println("saveFile"+saveFile);
	            System.out.println("uploadFile:"+uploadFile[i]);
	            System.out.println("ManagerInfo는"+managerInfo);
	            try {
	            	uploadFile[i].transferTo(saveFile);
	            }catch (Exception e) {
	               logger.error(e.getMessage());
	            }//end catch
			}
		System.out.println("managerInfo는"+managerInfo);
		authService.addManager(managerInfo);
		authService.addStores(managerInfo);
		authService.addItemList(managerInfo);
		authService.addMapData(managerInfo);
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

}
