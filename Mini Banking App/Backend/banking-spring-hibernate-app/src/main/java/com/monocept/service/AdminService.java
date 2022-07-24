package com.monocept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.model.Admin;
import com.monocept.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository  adminRepo;
	
	public AdminService()
	{
		System.out.println("Admin service created");
	}
	
	public void addAdmin(Admin admin)
	{
		adminRepo.addAdmin(admin);	
	}
	public Admin getAdmin()
	{
		return adminRepo.getAdmin();
	}
}
