package com.Mission.Service;

import java.util.List;

import com.Mission.Domain.MemberVO;
import com.Mission.dao.MemberDAO;
import com.Mission.dao.MemberInterface;

public class MemberService {
	private MemberInterface memberDao;
	
	public MemberService() {
		memberDao = new MemberDAO();
		//memberDao = new MemberDaoListImpl();
	}
	
	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDao.updateMember(member);
	}

	public int deleteMember(Integer id) {
		return memberDao.deleteMember(id);
	}
}
