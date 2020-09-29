package com.hk.pilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Member;
import com.hk.pilot.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public Member memberLogin(Member member) {
		return memberMapper.memberLogin(member);
	}

}
