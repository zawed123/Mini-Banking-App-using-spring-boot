package com.monocept.controller;

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
import com.monocept.model.Admin;
import com.monocept.service.AccountService;
import com.monocept.service.AdminService;

@RequestMapping("/api/v1/admin")
@RestController
public class AdminController {

	@Autowired
    AdminService adminservice;
	
	public AdminController()
	{
		System.out.println("Admin controller created");
	}
	
	@PostMapping(path = "/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		adminservice.addAdmin(admin);
		return ResponseEntity.ok(admin);
	}
	@GetMapping(path = "/admin")
	public ResponseEntity<Admin> getAdmin() {
		return ResponseEntity.ok(adminservice.getAdmin());
	}
}
