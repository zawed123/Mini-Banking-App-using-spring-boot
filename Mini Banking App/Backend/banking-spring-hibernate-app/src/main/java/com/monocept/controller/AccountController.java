package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.dto.AccountDTO;
import com.monocept.model.Account;
import com.monocept.service.AccountService;

@RequestMapping("/api/v1/account")
@RestController
public class AccountController {
	@Autowired
	AccountService accountservice;

	public AccountController() {
		System.out.println("Account controller");
	}
	@GetMapping(path = "/all")
	public List<Account> getAccount() {
		return accountservice.getAccountAll();
	}
	@PostMapping(path = "/add")
	public ResponseEntity<AccountDTO> addAccount(@RequestBody Account account) {
		System.out.println(account);
		accountservice.addAccount(account);
		return ResponseEntity.ok(accountservice.getAccount(account.getName()));
	}
	
	@GetMapping(path = "/{userName}")
	public AccountDTO getAccount(@PathVariable String userName) {
		return accountservice.getAccount(userName);
	}
}
