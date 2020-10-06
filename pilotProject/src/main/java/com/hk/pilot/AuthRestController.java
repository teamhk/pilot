package com.hk.pilot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hk.pilot.service.AuthService;


@RestController
@RequestMapping(path="/auth1", produces="text/plain;charset=UTF-8")
public class AuthRestController {

	private static final Logger logger = LoggerFactory.getLogger(AuthRestController.class);
	@Autowired
	AuthService authService;
	
	@Autowired
	ServletContext sc;
	
	@GetMapping(path="/addCustomer1", produces=MediaType.APPLICATION_JSON_VALUE)
	   public String checkIdDup(@RequestParam("id") String id) {
		System.out.println("타니?");   
		return authService.checkId(id);
	   }
	
	
   
	  @RequestMapping(path = "/uploadAjaxAction", method = RequestMethod.POST , headers = "content-type=multipart/*")//여기에 get으로 주면 당연히 컨트롤러는 못잡는다
		public void uploadAjaxPost(MultipartFile[] uploadFile) {
			logger.info("update ajax post.................");
			
			String uploadFolder = "C:\\upload";
			System.out.println("타니");
			for(MultipartFile multipartFile : uploadFile) {
				System.out.println("왜?");
				logger.info("---------------------------------");
				logger.info("Upload File Name :"+multipartFile.getOriginalFilename());
				logger.info("Upload File Size : " + multipartFile.getSize());
				
				String uploadFileName = multipartFile.getOriginalFilename();
				
				//IE has file path
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
				logger.info("only file name : " + uploadFileName);
				
				File saveFile = new File(uploadFolder, uploadFileName);
				System.out.println("saveFile"+saveFile);
				try {
					multipartFile.transferTo(saveFile);
				}catch (Exception e) {
					logger.error(e.getMessage());
				}//end catch
			}//end for
		}
}
