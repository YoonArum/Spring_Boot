package com.Mission.service;

import java.util.ArrayList;

import com.Mission.DB.MemberDAO;
import com.Mission.DB.MemberVO;

public class MemberService {

	

	MemberDAO dao = new MemberDAO();

	public MemberService() {				
	}

	public ArrayList<MemberVO> selectDB() {	
		System.out.println("========== selectDB ==========");
		return dao.selectsql(); 
	}

	public void insertDB(String id, String pass, String name) {	
		System.out.println("========== insertDB ==========");
		dao.insertsql(id, pass, name);
		
	}

	public void updateDB(String id, String pass, String name) {
		System.out.println("========== updateDB ==========");
		dao.updatesql(id, pass,name);
	}

	public MemberVO deleteDB(String id) {
		System.out.println("========== deleteDB ==========");		
		return dao.deleatesql(id);
	}

}
