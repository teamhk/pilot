package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.Notice;
import com.hk.pilot.dto.SearchCriteria;

public interface SupportMapper {
	
	public List<Notice> noticeList(SearchCriteria scri);// 공지사항 글 목록
	
	public int noticeListCount (SearchCriteria scri); //공지사항페이지 총 게시글 수
	
	public Notice selectOne(int  n_seq); //공지사항 글 상세 조회

}
