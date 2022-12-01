package com.Mission.dao;

import java.util.List;

import com.Mission.Domain.MemberVO;

public interface MemberInterface {
	
	List<MemberVO> getMembers();

	MemberVO getMember(Integer id);

	MemberVO addMember(MemberVO member);

	MemberVO updateMember(MemberVO member);

	int deleteMember(Integer id);

}
