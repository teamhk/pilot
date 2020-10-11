package com.hk.pilot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hk.pilot.dto.MapData;
import com.hk.pilot.service.AdminService;
import java.util.List;

@RestController
@RequestMapping(value="/admin/rest")
public class AdminRestController {
	private static final Logger logger = LoggerFactory.getLogger(AdminRestController.class);
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(path = "/map", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MapData> mapLoad(Model model) {
		logger.info("/admin/rest/mapLoad ----------");
		System.out.println("<<여기는 AdminRestController>>"+"맵데이터 로딩중입니다.");
		return adminService.mapLoad();
	}
}
