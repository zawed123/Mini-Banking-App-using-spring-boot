package com.monocept.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.model.Account;
import com.monocept.model.Transaction;

@Repository
public class AccountRepository {
	@PersistenceContext
	private EntityManager em;

	public AccountRepository() {
		System.out.println("Account Repository");
	}
	public List<Account> getAccountAll() {
		return em.createQuery("from Account").getResultList();
	}

	public Account getAccount(String userName) {
		return (Account) em
				.createQuery(
						"from Account where name= " + "\'" + userName + "\'")
				.getSingleResult();
	}

	@Transactional
	public void addAccount(Account account) {
		Transaction transaction = new Transaction(account.getBalance(), "Deposit");
		transaction.setAccount(account);
		account.getTransactions().add(transaction);
		em.persist(account);
	}

	@Transactional
	public void deleteAccount(String name) {
		Account account = (Account) em.createQuery("from Account where name=" + name + "").getSingleResult();
		em.remove(account);
	}

	@Transactional
	public Account getSingleAccount(String name) {
		return (Account) em.createQuery("from Account where name= " + "\'" + name + "\'").getSingleResult();

	}
}
