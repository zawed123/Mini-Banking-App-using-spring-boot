package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.model.Transaction;
import com.monocept.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	public TransactionService() {
		System.out.println("Transaction Service created");
	}

	public List<Transaction> getTransaction(String name) {
		return transactionRepository.getTransactions(name);
	}

	public void doTransaction(Transaction transaction, String name) {
		transactionRepository.doTransaction(transaction,name);
	}
}
