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
import com.Mission.domain.MemberVO;

@RestController
public class MemberController {

	// List 생성
	List<MemberVO> list;

	public MemberController() {
		list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			// membervo 객체에 값 집어넣기
			MemberVO membervo = new MemberVO(i, "이름" + i, "1234", new Date());
			list.add(membervo);
		}
	}

	// /getMember member 전체 값 불러오기
	@GetMapping("member")
	public List<MemberVO> getMember() {
		return list;
	}

	@GetMapping("member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {

		for (MemberVO m : list) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	@PostMapping("member")
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("post");

		MemberVO member = new MemberVO();

		member.setId(memberVO.getId());
		member.setPass(memberVO.getPass());
		member.setName(memberVO.getName());
		member.setRegidate(new Date());

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
		member.setRegidate(new Date());

		list.set(member.getId(), member);

		return member;
	}

	@DeleteMapping("member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
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
