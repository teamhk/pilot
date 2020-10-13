package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Notice;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.mapper.SupportMapper;

@Service
public class SupportService {

	@Autowired
	SupportMapper supportMapper;

	public List<Notice> noticeList(SearchCriteria scri){

		return supportMapper.noticeList(scri);
	}
	//게시물 총 개수
	public int noticeListCount(SearchCriteria scri) {

		System.out.println("chatService-listCount 호출");

		return supportMapper.noticeListCount(scri);
	}

	//게시물 상세 조회하기
	public Notice selectOne(int n_seq) {

		System.out.println("chatService-selectOne 호출");
		return supportMapper.selectOne(n_seq);
	}


}
