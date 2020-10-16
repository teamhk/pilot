package com.hk.pilot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.hk.pilot.dto.Stores;
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
}
