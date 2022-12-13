package com.src.edu.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeHttpRequests().requestMatchers("/member/**").authenticated().requestMatchers("/manager/**")
				.hasAnyRole("MANAGER", "ADMIN").requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll();

		http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);

		return http.build();
	}

	/*
	 * @Autowired public void autheticate(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication() .withUser("manager")
	 * .password("{noop}manager123").roles("MANAGER");
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("admin").password("{noop}admin123").roles("ADMIN"); }
	 */

	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	@Autowired
	public void autheticate(AuthenticationManagerBuilder auth) throws Exception {
		String query1 = "select id username, concat('{noop}',password) password, true enabled from member where id=?";
		String query2 = "select id,role from member where id =?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
}
