package com.monocept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.dto.AccountLogDto;
import com.monocept.jwthelper.JwtUtil;
import com.monocept.model.Account;
import com.monocept.model.JwtResponse;
import com.monocept.service.AccountService;
import com.monocept.service.CustomUserDetialService;

@RestController
@RequestMapping (path = "api/v1/banking/log")
public class LogController {
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private CustomUserDetialService customUserDetialService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public LogController() {
		System.out.println("log controller created");
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> accountLogin(@RequestBody AccountLogDto accountLogDto) throws Exception {
		System.out.println(accountLogDto);
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountLogDto.getUserName(), accountLogDto.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("user name password incorrect");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new BadCredentialsException("user name is inccorect");
		}
		
		// 
		UserDetails userDetails=this.customUserDetialService.loadUserByUsername(accountLogDto.getUserName());
		
		String token= this.jwtUtil.generateToken(userDetails);
		
		System.out.println("jwt token  "+token);
		
		
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	
	}
	@PostMapping(path = "/addAccount")
	public ResponseEntity<Account> post(@RequestBody Account account) {
		service.addAccount(account);
		return ResponseEntity.ok(account);
	}

}
