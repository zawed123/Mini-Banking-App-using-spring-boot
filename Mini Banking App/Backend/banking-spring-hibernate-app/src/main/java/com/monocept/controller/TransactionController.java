package com.monocept.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.model.Transaction;
import com.monocept.service.TransactionService;

@RequestMapping("/api/v1/account/{name}/transaction")
@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	public TransactionController() {
		System.out.println("Transaction Controller");
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String name) {
		return ResponseEntity.ok(transactionService.getTransaction(name));
	}

	@PostMapping(path = "/start")
	public ResponseEntity<Date> startTransaction(@PathVariable String name, @RequestBody Transaction transaction) {
		Transaction transactionToDo = new Transaction(transaction.getAmount(), transaction.getType());
		transactionService.doTransaction(transactionToDo, name);
		return ResponseEntity.ok(transaction.getDateTime());
	}
}
