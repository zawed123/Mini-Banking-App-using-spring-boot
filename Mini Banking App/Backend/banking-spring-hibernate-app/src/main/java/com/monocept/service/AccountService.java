package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.dto.AccountDTO;
import com.monocept.model.Account;
import com.monocept.model.Admin;
import com.monocept.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public AccountService() {
		System.out.println("Account Service created");
	}

	public List<Account> getAccountAll()
	{
		return accountRepository.getAccountAll();
	}
	public AccountDTO getAccount(String name) {
		AccountDTO accountDTO = null;
		Account account = accountRepository.getAccount(name);
		accountDTO = new AccountDTO(account.getName(), account.getBalance());
		return accountDTO;
	}

	public void addAccount(Account account) {
		accountRepository.addAccount(account);
	}
}
