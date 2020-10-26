package com.hk.pilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Members;
import com.hk.pilot.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public Members memberLogin(Members members) {
		return memberMapper.memberLogin(members);
	}

}
