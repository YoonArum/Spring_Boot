package com.src.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.src.edu.domain.Member;
import com.src.edu.persistence.MemberReposittory;

@SpringBootTest
class Chapter07ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private MemberReposittory memberRepo;
	
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member =new Member();
		member.setId("manager");
		member.setPassword(encoder.encode("manager123"));
		member.setName("매니저2");
	}

}
