package com.src.edu.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.src.edu.domain.Member;
import com.src.edu.persistence.MemberReposittory;

@Service
public class BoardUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberReposittory memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Member> optional = memberRepo.findById(username);
		if (!optional.isPresent()) {
			throw new UsernameNotFoundException(username + " 사용자를 찾을 수 없습니다.");
		}
		Member m = optional.get();
		return new User(m.getId(), m.getPassword(), AuthorityUtils.createAuthorityList(m.getRole().toString()));

	}
}
