package com.monocept.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monocept.model.Account;
import com.monocept.repository.AccountRepository;

@Service
public class CustomUserDetialService implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("load user name");
		
		try {
			Account acc = accountRepository.getSingleAccount(userName);
			return new User(acc.getName(), acc.getPassword(), new ArrayList<>());
		} catch (Exception e) {
			throw new UsernameNotFoundException("user name not found");
		}
		
	}

}
