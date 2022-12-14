package com.src.edu.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Member extends User {

	@Id
	private String id;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;



	public Member(Member member) {
		super(member.getId(), "{noop}" + member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}

	/*
	 * public Member(String id, String password, String name, Role role, boolean
	 * enabled) { super(); this.id = id; this.password = password; this.name = name;
	 * this.role = role; this.enabled = enabled; }
	 */

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + ", enabled="
				+ enabled + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
