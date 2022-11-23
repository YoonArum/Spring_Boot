package com.Mission.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mission.DB.MemberDAO;
import com.Mission.DB.MemberVO;
import com.Mission.service.MemberService;

@RestController
public class MemberController {

	MemberService service;

	static MemberDAO dao;

	// DB 불러오기
	public MemberController() {
		service = new MemberService();
		
	}

	// /getMember member 전체 값 불러오기
	@GetMapping("member")
	public ArrayList<MemberVO> getMember() {		
		return service.selectDB();
	}

	@PostMapping("member")
	public MemberVO InsertMember(MemberVO memberVO) {
		service.insertDB(memberVO.getId(), memberVO.getPass(), memberVO.getName());
		return null;
	}

	@PutMapping("member")
	public MemberVO updateMembers(MemberVO memberVO) {
		service.updateDB(memberVO.getId(), memberVO.getPass(), memberVO.getName());
		return null;
	}

	@DeleteMapping("member/{id}")
	public MemberVO removeMember(@PathVariable String id) {
		
		return service.deleteDB(id);
	}

}
