package com.Starkpro.myfirstApp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults ; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityCofiguration {
	
	// LDAP or Database 
	// In Memory 
	

	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
	
		
		UserDetails userDetails1 = createNewUser("Manoj", "Starkpro@123"); 
		UserDetails userDetails2 = createNewUser("Ranga", "Starkpro@1234"); 
		UserDetails userDetails3 = createNewUser("Leetcode", "Starkpro@12345"); 
		return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3) ; 
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
				
		.passwordEncoder(passwordEncoder)
		.username(username)
		.password(password) 
		.roles("USER" , "ADMIN")
		.build()  ;
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() ; 
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				) ; 
		http.formLogin(withDefaults()) ;
		
		http.csrf().disable() ; 
		http.headers().frameOptions().disable() ; 
		return http.build() ;
	}
	
}
