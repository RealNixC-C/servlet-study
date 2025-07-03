package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	
	MemberDao dao = new MemberDao();

	public int insertMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		int result = dao.insertMember(param);
		return result;
	}

	public Member selectMember(String memberId, String memberPw) {
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		Member result = dao.selectMember(param); 
		return result;
	}

	
	
}
