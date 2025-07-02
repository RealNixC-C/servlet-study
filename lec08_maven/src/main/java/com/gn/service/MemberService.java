package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	
	MemberDao dao = new MemberDao();

	public int insertMember(String id, String pw) {
		
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		
		return dao.insertMember(param);
		
	}

	
	
}
