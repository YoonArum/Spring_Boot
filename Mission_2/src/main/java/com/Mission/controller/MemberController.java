package com.Mission.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mission.DB.MemberDAO;
import com.Mission.DB.MemberVO;

@RestController
public class MemberController {
	List<MemberVO> list;
	static MemberDAO dao;

	// DB 불러오기
	public MemberController() {
		dao  = new MemberDAO();		
	}
	
	// /getMember member 전체 값 불러오기
	@GetMapping("member")
	public List<MemberVO> getMember() {
		return list;
	}
	
	@PostMapping("member")
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("post");

		MemberVO member = new MemberVO();

		member.setId(memberVO.getId());
		member.setPass(memberVO.getPass());
		member.setName(memberVO.getName());
		member.setRegidate(new String());

		list.add(member);

		return member;
	}

	@PutMapping("member")
	public MemberVO updateMembers(MemberVO memberVO) { 
		System.out.println("post");

		MemberVO member = new MemberVO();

		member.setId(memberVO.getId());
		member.setPass(memberVO.getPass());
		member.setName(memberVO.getName());
		member.setRegidate(new String());



		return member;
	}

	@DeleteMapping("member/{id}")
	public MemberVO removeMember(@PathVariable String id) {
		for (MemberVO m : list) {
			// id 값이 같을 경우
			if (m.getId() == id) {
				// remove 제거한다
				list.remove(m);
				return m;
			}
		}
		return null;
	}





	
}
