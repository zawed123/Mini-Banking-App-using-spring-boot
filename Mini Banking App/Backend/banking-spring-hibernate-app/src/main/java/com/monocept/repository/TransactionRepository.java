package com.monocept.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.model.Account;
import com.monocept.model.Transaction;

@Repository
public class TransactionRepository {
	@PersistenceContext
	private EntityManager em;

	public TransactionRepository() {
		System.out.println("Transaction Repository");
	}

	public List<Transaction> getTransactions(String name) {
		return (List<Transaction>) em.createQuery("from Transaction Where account_name=" + "\'" + name + "\'").getResultList();
	}
	
	@Transactional
	public void doTransaction(Transaction transaction, String name) {
		Account account= em.find(Account.class, name);
		double balanceBeforeTransaction = account.getBalance();
		double balanceAfterTransaction = 0;
		if (transaction.getType().equalsIgnoreCase("Deposit")) {
			balanceAfterTransaction = balanceBeforeTransaction + transaction.getAmount();
		} else if (transaction.getType().equalsIgnoreCase("Withdraw")) {
			balanceAfterTransaction = balanceBeforeTransaction - transaction.getAmount();
		}
		account.setBalance(balanceAfterTransaction);
		transaction.setAccount(account);
		account.getTransactions().add(transaction);
		em.merge(account);
	}
}
