package com.Mission.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Mission.DB.MemberDAO;
import com.Mission.DB.MemberVO;

public class MemberService {

	private static final Logger log = LoggerFactory.getLogger(MemberService.class);

	MemberDAO dao = new MemberDAO();

	public MemberService() {
		log.info("service 생성자");

	}

	public ArrayList<MemberVO> selectData() {
		System.out.println("========== selectDB ==========");
		
		return dao.selectsql();
	}

	public MemberVO insertData(String id, String pass, String name) {
		System.out.println("========== insertDB ==========");
		
		return dao.insertsql(id, pass, name);

	}

	public MemberVO updateData(String id, String pass, String name) {
		System.out.println("========== updateDB ==========");

		return dao.updatesql(id, pass, name);

	}

	public MemberVO deleteData(String id) {
		System.out.println("========== deleteDB ==========");
		
		return dao.deleatesql(id);
	}

	public MemberVO getData(String id) {
		System.out.println("========== deleteDB ==========");
		
		return dao.getMember(id);
	}

}
