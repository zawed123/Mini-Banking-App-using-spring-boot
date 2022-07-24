package com.monocept.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.monocept.model.Admin;

@Repository
public class AdminRepository {
	@PersistenceContext
	private EntityManager em;

	public AdminRepository() {
		System.out.println("Admin Repository");
	}

	@Transactional
	public void addAdmin(Admin admin) {
		em.persist(admin);
	}

	@Transactional
	public Admin getAdmin() {
		return  (Admin) em.createQuery("from Admin").getSingleResult();

	}
}
